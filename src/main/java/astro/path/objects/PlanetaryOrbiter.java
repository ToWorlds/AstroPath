package astro.path.objects;

import astro.path.controller.TelemetryData;

public class PlanetaryOrbiter extends Spacecraft {
    private String orbitParameters;
    private String scientificPayload;

    public PlanetaryOrbiter(String id, String status, TelemetryData telemetryData,
           String orbitParameters, String scientificPayload) {
    	
        super(id, "Planetary Orbiter", status, telemetryData);
        this.orbitParameters = orbitParameters;
        this.scientificPayload = scientificPayload;
    }

    
    public void showSpecialFunction() {
        System.out.println(id + " is orbiting with parameters: " + orbitParameters);
        System.out.println("Scientific payload: " + scientificPayload);
    }
}