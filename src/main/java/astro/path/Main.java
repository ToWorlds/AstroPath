package astro.path;

import java.io.File;

import astro.path.UI.MainApplication;
import astro.path.controller.DataController;
import astro.path.objects.*;

public class Main {

	public static void main(String[] args) {
		DataController myDC = new DataController();
		myDC.getSaveFile();
		myDC.createSaveFile();
		myDC.createSampleData();
		myDC.saveSession();
		myDC.readFile();
		Mission myMission = myDC.getMission("Starting Sputni");
		if (myMission != null) {
			System.out.println("Mission name found: " + myMission.name);
		} else {
			System.out.println("Mission not found.");
		}
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
