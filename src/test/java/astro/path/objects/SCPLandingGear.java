package astro.path.objects;

public class SCPLandingGear extends SCPart{
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
