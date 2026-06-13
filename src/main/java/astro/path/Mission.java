package astro.path;

public class Mission {

    private String name;
    private String phase;
    private String objective;
    private String launchDate;
    private String estDecommission;
    private int progressStatus;

    public Mission(String name, String phase, String objective,
            String launchDate, String estDecommission, int progressStatus) {
        this.name = name;
        this.phase = phase;
        this.objective = objective;
        this.launchDate = launchDate;
        this.estDecommission = estDecommission;
        this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
        return "Mission [name=" + name + ", phase=" + phase + ", objective=" + objective
                + ", launchDate=" + launchDate + ", estDecommission=" + estDecommission
                + ", progressStatus=" + progressStatus + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getEstDecommission() {
        return estDecommission;
    }

    public void setEstDecommission(String estDecommission) {
        this.estDecommission = estDecommission;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }
}