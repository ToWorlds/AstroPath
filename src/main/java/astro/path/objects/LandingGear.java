package astro.path.objects;

public class LandingGear extends SCPart {
	double health;
	double damagePerUse;
	
	public LandingGear() {
		this.health = 0.0;
		this.damagePerUse = 0.0;
		super.status = Status.OK;
	}
}
