package model;

public class Telemetry {
	
	private double speed;
	private double fuelLevel;
	private double distance;
	private double internalTemp;
	
	public Telemetry(double speed, double fuelLevel, double distance, double internalTemp) {
		
		this.speed = speed;
		this.fuelLevel = fuelLevel;
		this.distance = distance;
		this.internalTemp = internalTemp;
		
	}
	
	public double getSpeed() {return speed;}
	public double getFuelLevel() {return fuelLevel;}
	public double getDistance() {return distance;}
	public double getInternalTemp() {return internalTemp;}
	

}
