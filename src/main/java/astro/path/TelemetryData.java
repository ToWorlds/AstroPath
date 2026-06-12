package astro.path;

public class TelemetryData {
    private double fuelLevel;
    private double temperature;
    private double signalStrength;

    public TelemetryData(double fuelLevel, double temperature, double signalStrength) {
        this.fuelLevel = fuelLevel;
        this.temperature = temperature;
        this.signalStrength = signalStrength;
        validate();
    }

    public void validate() {
        if (fuelLevel < 0 || fuelLevel > 100) {
            throw new IllegalArgumentException("Fuel level must be between 0 and 100.");
        }

        if (temperature < -150 || temperature > 150) {
            throw new IllegalArgumentException("Temperature is outside valid range.");
        }

        if (signalStrength < 0 || signalStrength > 100) {
            throw new IllegalArgumentException("Signal strength must be between 0 and 100.");
        }
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getSignalStrength() {
        return signalStrength;
    }

   
    public String toString() {
        return "Fuel: " + fuelLevel + "%, Temperature: " + temperature + "°C, Signal: " + signalStrength + "%";
    }
}