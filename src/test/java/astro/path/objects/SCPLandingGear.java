package astro.path.objects;

public class SCPLandingGear extends SCFart{
	boolean retracted;
	
	public SCPLandingGear() {
		super();
		this.retracted = false;
		this.type = "LandingGear";
	}

	public boolean isRetracted() {
		return retracted;
	}
}
