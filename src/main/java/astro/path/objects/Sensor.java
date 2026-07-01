package astro.path.objects;

public class Sensor extends SCPart {
	double maxDataCapacity;
	double currentCapacityUsed;
	double dataCollectionRate;
	double dataTransmissionRate;
	double powerUsage;
	
	public Sensor() {
		this.maxDataCapacity = 0.0;
		this.currentCapacityUsed = 0.0;
		this.dataCollectionRate = 0.0;
		this.powerUsage = 0.0;
		this.dataTransmissionRate = 0.0;
		
	}

}
