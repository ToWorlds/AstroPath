package astro.path.objects;

public class SCPSolarPanel extends SCFart {
	boolean extended;
	double engeryOutput;
	
	public SCPSolarPanel() {
		this.type = "SolarPanel";
		this.extended = false;
		this.engeryOutput = 0;
	}

	public boolean isExtended() {
		return extended;
	}

	public double getEngeryOutput() {
		return engeryOutput;
	}
}
