package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class Spacecraft {
	public String missionID;
	public String name;
	public String id;
	public String type;
	public String status;
	public List<SCPart> SCPartList;
    
	public Spacecraft() {
		this.name = "NONE";
    	this.type = "NONE";
    	this.status = "NONE";
    	this.SCPartList = new ArrayList<SCPart>();
    	
	}

/*
    public Spacecraft(String missionID) {
    	this.missionID = missionID;
    	this.name = "NONE";
    	this.type = "NONE";
    	this.status = "NONE";
    	this.SCPartList = new ArrayList<SCPart>();
    }
*/

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

		// alle Teile durchgehen und nach kritischen/offline Zuständen suchen
		for (SCPart part : SCPartList) {
			if (part.getStatus() == SCPart.Status.CRITICAL) {
				return id + ": Warning - a part is in CRITICAL condition!";
			}
			if (part.getStatus() == SCPart.Status.OFFLINE) {
				return id + ": Warning - a part is OFFLINE!";
			}
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
 // Überblick über den Zustand aller Teile
 	public String getPartsReport() {
 		StringBuilder report = new StringBuilder();
 		report.append(id).append(" parts status:\n");
 		for (SCPart part : SCPartList) {
 			report.append("  - ").append(part.getClass().getSimpleName())
 					.append(": ").append(part.getStatus()).append("\n");
 		}
		return report.toString();
 	}

    public String getType() {
        return type;
    }
    
    public List<SCPart> getSCPartList() {
    	return SCPartList;
    }

	public TelemetryData getTelemetry() {
		return telemetryData;
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

    public void showSpecialFunction() {
    	
    };

    
    public String toString() {
        return id + " | " + type + " | Status: " + status + " | " /*+ telemetryData*/;
    }
}
