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
	
	public void getSampleData() {
		System.out.println("Hello There!");
		File storageFile;
		ObjectMapper mapper = new ObjectMapper();
		JFileChooser fileChooser = new JFileChooser();
		try {
			// Declaring Filepath
			
			// Using javax.swing.JFileChooser
			int response = fileChooser.showOpenDialog(null); //select file to open
			if (response == JFileChooser.APPROVE_OPTION) {
				storageFile= new File(fileChooser.getSelectedFile().getAbsolutePath());
			} else {
				// Default: in case of not chosen
				storageFile = new File("src/main/resources/ExampleSession.apos.json");
			}
			storageFile.createNewFile();
			// Creating Sample data for test input
			
			Session mySession = new Session();
			Mission myMission = new Mission(mySession.id);
			MissionStage myMissionStage = new MissionStage(myMission.id);
			Spacecraft mySpacecraft = new Spacecraft(myMission.id);
			Thruster myThruster = new Thruster(mySpacecraft.id);
			
			
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
			myMissionStage.StartStage();
			
			myMission.name = "Starting Sputnik";
			myMission.SCList.add(mySpacecraft);
			myMission.MissionStageList.add(myMissionStage);
			
			mySession.name = "Farting Session";
			mySession.missionList.add(myMission);
			
			/*
			List<Spacecraft> mySCList = new ArrayList<Spacecraft>();
			Spacecraft mySC = new Spacecraft("Mike Hunterz", "Rocket", "alright");
			mySC.addSCPart(new Thruster());
			mySC.addSCPart(new SolarPanel());
			mySC.addSCPart(new Sensor());
			mySCList.add(mySC);
	*/
			System.out.println("Breakpoint");
			
			// Output Stream Init
			OutputStream outputStream = 
					new FileOutputStream(storageFile);
			// Output data into file
			mapper
			.writerWithDefaultPrettyPrinter()
			.writeValue(outputStream, mySession);
			outputStream.close();
			
			
			// Input Stream init
			InputStream inputStream = new FileInputStream(storageFile);
			// Creating Mapping Reference for proper input
			TypeReference<Session> typeReference = new TypeReference<Session>() {};
			// Creating integratable Dataset 
			Session session = mapper.readValue(inputStream, typeReference);
			// Basic Object handling
			System.out.println("Session: '" + session.name +
					"' has " + session.missionList.size()+ " Mission(s)");
			inputStream.close();
		} catch (FileNotFoundException e) {
			//System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (InvalidDefinitionException e) {
			//System.out.println("InvalidDefinitionException");
			e.printStackTrace();
		} catch (MismatchedInputException e) {
			//System.out.println("MismatchedInputException");
			e.printStackTrace();
		} catch (JacksonException e) {
			//System.out.println("JacksonException");
			e.printStackTrace();
		} catch (IOException e) {
			//System.out.println("IOException");
			e.printStackTrace();
		}
	}

}
