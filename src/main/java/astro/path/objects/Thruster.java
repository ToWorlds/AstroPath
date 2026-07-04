package astro.path.objects;

public class Thruster extends SCPart{
	public double consumptionRate;
	public double thrust;
	public double velocity;
	public double maxCapacity;
	public double currentCapacity;

	public Thruster(String SCID) {
		super.SCID = SCID;
		this.consumptionRate = 0.0;
		this.thrust = 0.0;
		this.velocity = 0.0;
		this.maxCapacity = 0.0;
		this.currentCapacity = 0.0;
		super.status = Status.OK;
	}
}
