package astro.path.objects;

public class SolarPanel extends SCPart {
	double productionRate;
	double maxCapacity;
	double currentCapacity;

	// Standard-Konstruktor: alles auf 0, Status OK
	public SolarPanel() {
		this.productionRate = 0.0;
		this.maxCapacity = 0.0;
		this.currentCapacity = 0.0;
		super.status = Status.OK;
	}

	// Konstruktor mit echten Werten
	public SolarPanel(double productionRate, double maxCapacity) {
		this.productionRate = productionRate;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = 0.0; // startet leer und lädt auf
		super.status = Status.EMPTY;
	}

	// Das Panel arbeitet: erzeugt Energie und lädt den Speicher auf
	public void operate() {
		this.currentCapacity = this.currentCapacity + this.productionRate;

		// Speicher kann nicht über das Maximum hinaus geladen werden
		if (this.currentCapacity > this.maxCapacity) {
			this.currentCapacity = this.maxCapacity;
		}

		updateStatus();
	}

	// Status je nach Ladezustand des Speichers setzen
	private void updateStatus() {
		if (this.currentCapacity <= 0) {
			super.status = Status.EMPTY;
		} else if (this.currentCapacity <= this.maxCapacity * 0.1) {
			super.status = Status.CRITICAL;
		} else if (this.currentCapacity <= this.maxCapacity * 0.2) {
			super.status = Status.WARNING;
		} else {
			super.status = Status.OK;
		}
	}

	// Getter
	public double getProductionRate() {
		return productionRate;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

	public double getCurrentCapacity() {
		return currentCapacity;
	}

	// Setter
	public void setProductionRate(double productionRate) {
		this.productionRate = productionRate;
	}

	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setCurrentCapacity(double currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		return "SolarPanel [productionRate=" + productionRate
				+ ", currentCapacity=" + currentCapacity + "/" + maxCapacity
				+ ", status=" + super.status + "]";
	}
}