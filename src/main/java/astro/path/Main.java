package astro.path;

import java.io.File;

import astro.path.UI.MainApplication;
import astro.path.controller.DataController;
import astro.path.objects.*;

public class Main {

	public static void main(String[] args) {
		/*
		DataController myDC = new DataController();
		File myFile = myDC.getSaveFile();
		myDC.createSaveFile(myFile);
		Session mySession = myDC.createSampleData();
		myDC.saveSession(myFile, mySession);
		myDC.readFile(myFile);
		*/
		/*
		Mission myMission = myDC.getMission(mySession, "Starting Sputni");
		if (myMission != null) {
			System.out.println("Mission name found: " + myMission.name);
		} else {
			System.out.println("Mission not found.");
		}
		*/
		MainApplication.main(args);
	}
	
	public Mission findMissionWithName( Session mySession, String name) {
		for (Mission mission : mySession.missionList) {
			if (mission.name.equals(name)) {
				return mission;
			}
		}
		return null;
	}
	

}
