package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class Mission {
	
	public String sessionID;
	public String id;
	public List<Spacecraft> SCList;
	public List<MissionStage> MissionStageList;
	public String name;
/*
	public MissionStage currentMissionStage;
	public String objective;
	public Time startTimestamp;
	public Time targetTimestamp;
	public int progressStatus;
*/
	
/*
    public Mission(String name, MissionStage stage, String objective,
            Time launchDate, Time targetTimeStamp, int progressStatus,
            String sessionID, String id, List<Spacecraft> SCList) {
        this.name = name;
        this.currentMissionStage = stage;
        this.objective = objective;
        this.startTimestamp = launchDate;
        this.targetTimestamp = targetTimeStamp;
        this.progressStatus = progressStatus;
        this.sessionID = sessionID;
        this.SCList = SCList;
        this.id = id;
    }
*/
	public Mission() {
		this.SCList = new ArrayList<Spacecraft>();
    	this.MissionStageList = new ArrayList<MissionStage>();  
    	this.name = "WITHOUT SessionID";
    	this.id = "0";
    	
    	MissionStage startMS = new MissionStage(this.id);
    	startMS.name = "Nothing yet";
    	this.MissionStageList.add(startMS);
	}
	
    public Mission(String sessionID) {
    	this.sessionID = sessionID;
    	this.SCList = new ArrayList<Spacecraft>();
    	this.MissionStageList = new ArrayList<MissionStage>();  
    	this.name = "WITH SessionID";
    	this.id = "0";
    	
    	MissionStage startMS = new MissionStage(this.id);
    	startMS.name = "Nothing yet";
    	this.MissionStageList.add(startMS);
    	
    	
    }
    
/*
    @Override
    public String toString() {
        return "Mission [name=" + name + ", phase=" + currentMissionStage + ", objective=" + objective
                + ", launchDate=" + startTimestamp + ", estDecommission=" + targetTimestamp
                + ", progressStatus=" + progressStatus + "]";
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public MissionStage getStage() {
        return currentMissionStage;
    }

    public void setStage(MissionStage stage) {
        this.currentMissionStage = stage;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Time getLaunchDate() {
        return startTimestamp;
    }

    public void setLaunchDate(Time launchDate) {
        this.startTimestamp = launchDate;
    }


    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }
*/
	public String getSessionID() {
		return sessionID;
	}

	public void setSession(String sessionID) {
		this.sessionID = sessionID;
	}

	public List<Spacecraft> getSCList() {
		return SCList;
	}

	public void setSCList(List<Spacecraft> sCList) {
		SCList = sCList;
	}
/*
	public Time getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Time startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Time getTargetTimestamp() {
		return targetTimestamp;
	}

	public void setTargetTimestamp(Time targetTimestamp) {
		this.targetTimestamp = targetTimestamp;
	}
	*/
}