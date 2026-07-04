package astro.path.objects;

import astro.path.objects.SCPart.Status;

public class LandingGear extends SCPart {
	double health;
	double damagePerUse;
	
	public LandingGear(String SCID) {
		this.health = 0.0;
		this.damagePerUse = 0.0;
		super.SCID = SCID;
		super.status = Status.OK;
	}
}
