package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class MissionStage {
	public String name;
	public List<SCPart> activatedParts; // Change String Class into RocketPart Class
	public String missionID;
	public Time targetTime;
	public Time currentTime;
	public Time startTime;
	
	public MissionStage(String missionID) {
		this.name = "UNNAMED";
		this.missionID = missionID;
		this.activatedParts = new ArrayList<SCPart>();
		this.startTime = new Time();
		this.targetTime = new Time();
		Thruster sampleThruster = new Thruster();
		this.activatedParts.add(sampleThruster);
	}
	
	
	public MissionStage() {
		this.name = "UNNAMED";
		this.activatedParts = new ArrayList<SCPart>();
		Thruster sampleThruster = new Thruster();
		this.activatedParts.add(sampleThruster);
		this.startTime = new Time();
		this.targetTime = new Time();
	}
	
	
	public void StartStage(Time currentTime) {
		this.startTime.seconds = currentTime.seconds;
		this.currentTime.seconds = 0;
	}
	
	public void addActivatedPart(SCPart scp) {
		this.activatedParts.add(scp);
	}
	
	public int update(Time timeDiff) {
		this.currentTime.seconds += timeDiff.seconds;
		if (this.currentTime.seconds > this.targetTime.seconds) {
			return 1;
		} else {
			return 0;
		}
		
		
	}
}
