package astro.path.objects;

public class Thruster extends SCPart{
	double consumptionRate;
	double thrust;
	double velocity;
	double maxCapacity;
	double currentCapacity;

	public Thruster() {
		this.consumptionRate = 0.0;
		this.thrust = 0.0;
		this.velocity = 0.0;
		this.maxCapacity = 0.0;
		this.currentCapacity = 0.0;
		super.status = Status.OK;
	}
}
