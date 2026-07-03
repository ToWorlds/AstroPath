package astro.path.objects;

import astro.path.controller.TelemetryData;
import java.util.List;
import java.util.ArrayList;

public abstract class Spacecraft {
	List<SCPart> SCPartList;
	String name;
	protected String id;
	protected String type;
	protected String status;
	protected TelemetryData telemetryData;

	public Spacecraft(String id, String type, String status, TelemetryData telemetryData) {
		this.id = id;
		this.type = type;
		this.status = status;
		this.telemetryData = telemetryData;
		this.SCPartList = new ArrayList<>(); // Liste leer erzeugen, sonst null
	}

	// Ein Teil zum Spacecraft hinzufügen
	public void addPart(SCPart part) {
		SCPartList.add(part);
	}

	// Gesamtdiagnose: prüft Telemetrie UND alle Teile
	public String performSelfDiagnostic() {
		if (telemetryData.getFuelLevel() < 10) {
			return id + ": Warning - Low fuel!";
		}
		if (telemetryData.getSignalStrength() < 20) {
			return id + ": Warning - Weak signal!";
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

	public abstract void showSpecialFunction();

	public String toString() {
		return id + " | " + type + " | Status: " + status + " | " + telemetryData;
	}
}