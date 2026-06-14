package astro.path;

public class MissionControlDashboard {

    private String viewState;
    private MissionCoordinator coordinator;

    public MissionControlDashboard(MissionCoordinator coordinator) {
        this.coordinator = coordinator;
        this.viewState = "Telemetry";
    }

    public void displayTelemetry() {
        System.out.println("=== Telemetry View ===");
        for (Spacecraft s : coordinator.getManagedFleet()) {
            System.out.println(s.getId() + " | " + s.getTelemetry());
        }
    }

    public void renderTrajectoryViz() {
        System.out.println("=== Trajectory Visualization ===");
        for (Spacecraft s : coordinator.getManagedFleet()) {
            System.out.println(s.getId() + " (" + s.getType() + ") -> status: " + s.getStatus());
        }
    }

    public void logEventDisplay() {
        System.out.println("=== Event Log ===");
        for (Mission m : coordinator.getCurrentMissions()) {
            System.out.println(m.getName() + " | phase: " + m.getPhase()
                    + " | progress: " + m.getProgressStatus() + "%");
        }
    }

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }
}