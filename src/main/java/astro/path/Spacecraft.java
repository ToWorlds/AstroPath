package astro.path;

public abstract class Spacecraft {
    protected String id;
    protected String type;
    protected String status;
    protected TelemetryData telemetryData;

    public Spacecraft(String id, String type, String status, TelemetryData telemetryData) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.telemetryData = telemetryData;
    }

    public TelemetryData getTelemetry() {
        return telemetryData;
    }

    public String performSelfDiagnostic() {
        if (telemetryData.getFuelLevel() < 10) {
            return id + ": Warning - Low fuel!";
        }

        if (telemetryData.getSignalStrength() < 20) {
            return id + ": Warning - Weak signal!";
        }

        return id + ": All systems normal.";
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void showSpecialFunction();

    
    public String toString() {
        return id + " | " + type + " | Status: " + status + " | " + telemetryData;
    }
}
