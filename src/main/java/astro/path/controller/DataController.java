package astro.path.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.InvalidDefinitionException;
import tools.jackson.databind.exc.MismatchedInputException;

import astro.path.objects.*;

public class DataController {
	
	public Session mySession;
	public File myStorageFile;
	
	public DataController() {
		
	}
	
	public void getSaveFile() {
		File storageFile;
		JFileChooser fileChooser = new JFileChooser();
		
		// Declaring Filepath
			
		// Using javax.swing.JFileChooser
		int response = fileChooser.showOpenDialog(null); //select file to open
		if (response == JFileChooser.APPROVE_OPTION) {
			storageFile= new File(fileChooser.getSelectedFile().getAbsolutePath());
		} else {
		// Default: in case of not chosen
			storageFile = new File("src/main/resources/ExampleSession.apos.json");
		}
		this.myStorageFile = storageFile;
	}
		
	public void createSaveFile() {
		try {
			this.myStorageFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createSampleData() {
		Session mySession = new Session();
		Mission myMission = new Mission();
		MissionStage myMissionStage = new MissionStage();
		Spacecraft mySpacecraft = new Spacecraft();
		Thruster myThruster = new Thruster();
		
		
		myThruster.consumptionRate = 10.0;
		myThruster.maxCapacity = 100;
		myThruster.currentCapacity = myThruster.maxCapacity;
		
		mySpacecraft.name = "Sputnik";
		mySpacecraft.id = "1337";
		mySpacecraft.type = "UFO";
		mySpacecraft.status = "I'm not Hungry";
		mySpacecraft.addSCPart(myThruster);
		
		myMissionStage.name = "Sputnik -> Kaputnik";
		myMissionStage.activatedParts.add(mySpacecraft.SCPartList.get(0));
		myMissionStage.StartStage(mySession.currentTime);
		
		myMission.name = "Starting Sputnik";
		myMission.SCList.add(mySpacecraft);
		myMission.MissionStageList.add(myMissionStage);
		
		mySession.name = "First Session";
		mySession.missionList.add(myMission);
		
		this.mySession = mySession;
	}
	
	public void saveSession() {
		// Output Stream Init
			ObjectMapper mapper = new ObjectMapper();
			OutputStream outputStream;
			try {
				outputStream = new FileOutputStream(this.myStorageFile);
			// Output data into file
				mapper
					.writerWithDefaultPrettyPrinter()
					.writeValue(outputStream, this.mySession);
				outputStream.close();
			}  catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void readFile() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(this.myStorageFile);
			// Creating Mapping Reference for proper input
			TypeReference<Session> typeReference = new TypeReference<Session>() {};
			// Creating integratable Dataset 
			Session session = mapper.readValue(inputStream, typeReference);
			
			// Basic Object handling
			System.out.println("Session: '" + session.name +
				"' has " + session.missionList.size()+ " Mission(s)");
			for(Mission mission : session.missionList) {
				System.out.println("Mission is called '" + mission.name + "'");
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			// Creating Sample data for test input	
		
	public Mission getMission(String missionName) {
		for (Mission mission : this.mySession.missionList) {
			if (mission.name.equals(missionName)) {
				return mission;
			}
		}
		return null;
	}
	

	public Spacecraft getSpacecraft(String missionName, String SCName) {
		Mission myMission = getMission(missionName);
		if (myMission == null) {
			return null;
		}
		for (Spacecraft SC : myMission.SCList) {
			if (SC.name.equals(SCName)) {
				return SC;
			}
		}
		return null;	
	}

	public SCPart getSCPart(String missionName, String scName, String scpName) {
		Spacecraft mySC = getSpacecraft(missionName, scName);
		if (mySC == null) {
			return null;
		}
		for(SCPart scp : mySC.SCPartList) {
			if (scp.name.equals(scpName)) {
				return scp;
			}
		}
		return null;
	}
	
	
	public MissionStage getMissionStage(String missionName, String stageName) {
		Mission myMission = getMission(missionName);
		if (myMission == null) {
			return null;
		}
		for(MissionStage myStage : myMission.MissionStageList) {
			if (myStage.name.equals(stageName)) {
				return myStage;
			}
		}
		return null;
	}
	
	public SCPart getActivatedPart(String missionName, String stageName, String ascpName) {
		MissionStage myMissionStage = getMissionStage(missionName,stageName);
		if (myMissionStage == null) {
			return null;
		}
		for (SCPart myASCPart : myMissionStage.activatedParts) {
			if (myASCPart.name.equals(ascpName)){
				return myASCPart;
			}
		}
		return null;
	}
	public Session exTimeStep(Session mySession, Time timeStep) {
		mySession.currentTime.seconds += timeStep.seconds;
		return mySession;
	}
	
	public void startTimeUpdater(Session mySession) {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(() -> {
		    updateSession();
		}, 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	public void updateSession() {
		Time timeDiff = new Time();
		timeDiff.seconds = this.mySession.currentTime.seconds -
				this.mySession.oldTime.seconds;
		for (Mission myMission : this.mySession.missionList) {
			for (Spacecraft mySpacecraft : myMission.SCList) {
				for (SCPart mySCPart : mySpacecraft.SCPartList) {
					mySCPart.operate(timeDiff);
				}
				/* Current Stage is incremented if current time 
				 * exceeds target time.
				 */
				myMission.currentStage +=
						myMission.MissionStageList.get(
						myMission.currentStage)
				.update(timeDiff);
			}
		}
	}
}
