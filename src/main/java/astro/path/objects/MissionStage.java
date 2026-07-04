package astro.path.objects;

import java.util.List;


import java.util.ArrayList;

public class MissionStage {
	public String name;
	public List<SCPart> activatedParts; // Change String Class into RocketPart Class
	public String missionID;
	public Time targetTime;
	public Time startTime;
	
	public MissionStage(String missionID) {
		this.name = "UNNAMED";
		this.missionID = missionID;
		this.activatedParts = new ArrayList<SCPart>();
		this.startTime = new Time();
		this.targetTime = new Time();
	}
	
	public MissionStage() {
		this.name = "UNNAMED";
		this.activatedParts = new ArrayList<SCPart>();
	}
	
	
	public void StartStage() {
		this.startTime.seconds = 0;
	}
	
	public void addActivatedPart(SCPart scp) {
		this.activatedParts.add(scp);
	}

}
