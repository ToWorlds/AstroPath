package astro.path;

public class ResourceExpenditurePredictor {

    private double powerModel;
    private TelemetryData telemetryData;

    public ResourceExpenditurePredictor(double powerModel, TelemetryData telemetryData) {
        this.powerModel = powerModel;
        this.telemetryData = telemetryData;
    }

    public double calculateRemainingDuration() {
        if (powerModel <= 0) {
            return -1;
        }
        return telemetryData.getFuelLevel() / powerModel;
    }

    public double getPowerModel() {
        return powerModel;
    }

}