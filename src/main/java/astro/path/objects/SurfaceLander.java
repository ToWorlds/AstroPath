package astro.path.objects;

import astro.path.controller.TelemetryData;

public class SurfaceLander extends Spacecraft {
    private String mobilitySystem;
    private String landingGearStatus;

    public SurfaceLander(String id, String status, TelemetryData telemetryData,
                         String mobilitySystem, String landingGearStatus) {
        super(id, "Surface Lander", status, telemetryData);
        this.mobilitySystem = mobilitySystem;
        this.landingGearStatus = landingGearStatus;
    }

    
    public void showSpecialFunction() {
        System.out.println(id + " uses mobility system: " + mobilitySystem);
        System.out.println("Landing gear status: " + landingGearStatus);
    }
}
