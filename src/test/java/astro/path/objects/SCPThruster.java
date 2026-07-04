package astro.path.objects;

public class SCPThruster extends SCFart{
	boolean activated;
	 
	public SCPThruster() {
		this.type = "Thruster";
		this.activated = false;
	}

	public boolean isActivated() {
		return activated;
	}
}
