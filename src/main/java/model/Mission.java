package model;

public class Mission {
	
	private String name;
	private String stage;
	private String objective;
	private String start;
	private String end;
	
	public Mission(String name, String stage, String objective, String start, String end) {
		
		this.name = name;
		this.stage = stage;
		this.objective = objective;
		this.start = start;
		this.end = end;
		
	}
	
	public String getMissionName() {return name;}
	public String getMissionStage() {return stage;}
	public String getMissionObjective() {return objective;}
	public String getMissionStart() {return start;}
	public String getMissionEnd() {return end;}
	
}
