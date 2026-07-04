package astro.path.objects;

public class SolarPanel extends SCPart {
	double productionRate;
	double maxCapacity;
	double currentCapacity;
	
	public SolarPanel(String SCID) {
		super.SCID = SCID;
		this.productionRate = 0.0;
		this.maxCapacity = 0.0;
		this.currentCapacity = 0.0;
		super.status = Status.OK;
	}
}
