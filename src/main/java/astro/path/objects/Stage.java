package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class Stage {
	String name;
	List<String> activatedParts; // Change String Class into RocketPart Class
	Mission mission;
	Time targetTime;
	Time startTime;
	
	public Stage(Mission mission) {
		this.name = "UNNAMED";
		this.mission = mission;
		this.activatedParts = new ArrayList<String>();
	}
	
	
	
	public void StartStage(Time startTime) {
		this.startTime = mission.session.currentTime;
	}
	

}
