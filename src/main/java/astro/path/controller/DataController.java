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

import javax.swing.JFileChooser;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.InvalidDefinitionException;
import tools.jackson.databind.exc.MismatchedInputException;

import astro.path.objects.*;

public class DataController {
	
	public DataController() {
		
	}
	
	public File getSaveFile() {
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
		return storageFile;
	}
		
	public void createSaveFile(File saveFile) {
		try {
			saveFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Session createSampleData() {
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
		
		return mySession;
	}
	
	public void saveSession(File storageFile, Session mySession) {
		// Output Stream Init
			ObjectMapper mapper = new ObjectMapper();
			OutputStream outputStream;
			try {
				outputStream = new FileOutputStream(storageFile);
			// Output data into file
				mapper
					.writerWithDefaultPrettyPrinter()
					.writeValue(outputStream, mySession);
				outputStream.close();
			}  catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void readFile(File storageFile) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(storageFile);
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
		
	public Mission getMission( Session mySession, String missionName) {
		for (Mission mission : mySession.missionList) {
			if (mission.name.equals(missionName)) {
				return mission;
			}
		}
		return null;
	}
	
	public Spacecraft getSpacecraft(Mission myMission, String SCName) {
		for (Spacecraft SC : myMission.SCList) {
			if (SC.name.equals(SCName)) {
				return SC;
			}
		}
		return null;	
	}
	
	public SCPart getSCPart(Spacecraft mySC, String scpName) {
		for(SCPart scp : mySC.SCPartList) {
			if (scp.name.equals(scpName)) {
				return scp;
			}
		}
		return null;
	}
	
	public SCPart getSCPart(Mission myMission, String scName, String scpName) {
		Spacecraft mySC = getSpacecraft(myMission, scName);
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
	
	public SCPart getSCPart(Session mySession,
			String missionName, String scName, String scpName) {
		Mission myMission = getMission(mySession, missionName);
		if (myMission == null) {
			return null;
		}
		Spacecraft mySC = getSpacecraft(myMission, scName);
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
	
	public MissionStage getMissionStage(Mission myMission, String stageName) {
		for(MissionStage myStage : myMission.MissionStageList) {
			if (myStage.name.equals(stageName)) {
				return myStage;
			}
		}
		return null;
	}
	public MissionStage getMissionStage(Session mySession, String missionName, String stageName) {
		Mission myMission = getMission(mySession, missionName);
		if (myMission == null) {
			return null;
		} else {
			for(MissionStage myStage : myMission.MissionStageList) {
				if (myStage.name.equals(stageName)) {
					return myStage;
				}
			} 
			return null;
		}
	}
	
	public SCPart getActivatedSCPart(MissionStage myStage, String ascpName) {
		for (SCPart ascp : myStage.activatedParts) {
			if (ascp.name.equals(ascpName)) {
				return ascp;
			}
		}
		return null;
	}
	
	public SCPart getActivatedSCPart(Mission myMission,String stageName, String ascpName) {
		MissionStage myStage = getMissionStage(myMission, stageName);
		if (myStage == null) {
			return null;
		}
		for (SCPart ascp : myStage.activatedParts) {
			if (ascp.name.equals(ascpName)) {
				return ascp;
			}
		}
		return null;
	}
	
	public SCPart getActivatedSCPart(Session mySession, String missionName,String stageName, String ascpName) {
		Mission myMission = getMission(mySession, missionName);
		MissionStage myStage = getMissionStage(myMission, stageName);
		if (myStage == null) {
			return null;
		}
		for (SCPart ascp : myStage.activatedParts) {
			if (ascp.name.equals(ascpName)) {
				return ascp;
			}
		}
		return null;
	}
	
	public Session exTimeStep(Session mySession, Time timeStep) {
		mySession.currentTime.seconds += timeStep.seconds;
		return mySession;
	}
	
	public Session updateSession(Session mySession) {
		Time timeDiff = new Time();
		timeDiff.seconds = mySession.currentTime.seconds -
				mySession.oldTime.seconds;
		for (Mission myMission : mySession.missionList) {
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
		return mySession;
	}
}
