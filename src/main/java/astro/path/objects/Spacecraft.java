package astro.path.objects;

import java.util.List;

import astro.path.objects.SCPart.Status;

import java.util.ArrayList;

public class Spacecraft {
	public String missionID;
	public String name;
	public String id;
	public String type;
	public String status;
	public List<SCPart> SCPartList;
    
    public Spacecraft(String missionID) {
    	this.missionID = missionID;
    	this.name = "NONE";
    	this.id = "Spacecraft";
    	this.type = "NONE";
    	this.status = "NONE";
    	this.SCPartList = new ArrayList<SCPart>();
    }
    
    public Spacecraft(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.SCPartList = new ArrayList<SCPart>();
    }

    public void addSCPart(SCPart scp) {
    	this.SCPartList.add(scp);
    }
    
 /*   
    public TelemetryData getTelemetry() {
        return telemetryData;
    }
List
    public String performSelfDiagnostic() {
        if (telemetryData.getFuelLevel() < 10) {
            return id + ": Warning - Low fuel!";
        }

        if (telemetryData.getSignalStrength() < 20) {
            return id + ": Warning - Weak signal!";
        }

        return id + ": All systems normal.";
    }
*/
    public String getName() {
    	return name;
    }
    
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    public List<SCPart> getSCPartList() {
    	return SCPartList;
    }

    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void showSpecialFunction() {
    	
    };

    
    public String toString() {
        return id + " | " + type + " | Status: " + status + " | " /*+ telemetryData*/;
    }
}
