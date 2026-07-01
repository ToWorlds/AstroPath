package astro.path.objects;

import java.util.List;

public class Mission {
	
	Session session;
	List<Spacecraft> SCList;
    private String name;
    private Stage stage;
    private String objective;
    private Time startTimestamp;
    private Time targetTimestamp;
    private int progressStatus;

    public Mission(String name, Stage stage, String objective,
            Time launchDate, Time targetTimeStamp, int progressStatus,
            Session session, List<Spacecraft> SCList) {
        this.name = name;
        this.stage = stage;
        this.objective = objective;
        this.startTimestamp = launchDate;
        this.targetTimestamp = targetTimeStamp;
        this.progressStatus = progressStatus;
        this.session = session;
        this.SCList = SCList;
    }

    @Override
    public String toString() {
        return "Mission [name=" + name + ", phase=" + stage + ", objective=" + objective
                + ", launchDate=" + startTimestamp + ", estDecommission=" + targetTimestamp
                + ", progressStatus=" + progressStatus + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Spacecraft> getSCList() {
		return SCList;
	}

	public void setSCList(List<Spacecraft> sCList) {
		SCList = sCList;
	}

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
}