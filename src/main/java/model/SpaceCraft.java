package model;

public class SpaceCraft {
	
	private String name;
	private String type;
	private String status;
	
	private Telemetry telemetry;
	private Mission mission;
	
	public SpaceCraft(String name, String type, String status) {
		
		this.name = name;
		this.type = type;
		this.status = status;
	}
	
	public String getName() {return name;}
	public String getType() {return type;}
	public String getStatus() {return status;}
	
	public Telemetry getTelemetry() {return telemetry;}
	public void setTelemetry(Telemetry telemetry) {this.telemetry = telemetry;}
	
	public void setMission(Mission mission) {this.mission = mission;}
	public String getMissionName() {return mission != null ? mission.getMissionName() : "";}

}
