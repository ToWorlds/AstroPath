package astro.path.objects;

public class Thruster extends SCPart {
	double consumptionRate;
	double thrust;
	double velocity;
	double maxCapacity;
	double currentCapacity;

	// Standard-Konstruktor: alles auf 0, Status OK
	public Thruster() {
		this.consumptionRate = 0.0;
		this.thrust = 0.0;
		this.velocity = 0.0;
		this.maxCapacity = 0.0;
		this.currentCapacity = 0.0;
		super.status = Status.OK;
	}

	// Konstruktor mit echten Werten
	public Thruster(double consumptionRate, double thrust, double velocity, double maxCapacity) {
		this.consumptionRate = consumptionRate;
		this.thrust = thrust;
		this.velocity = velocity;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = maxCapacity; // startet voll betankt
		super.status = Status.OK;
	}

	// Der Thruster arbeitet: verbraucht Treibstoff und aktualisiert seinen Status
	public void operate() {
		// Kein Treibstoff mehr: Thruster schaltet ab
		if (currentCapacity <= 0) {
			shutDown();
			return;
		}

		this.currentCapacity = this.currentCapacity - this.consumptionRate;

		if (this.currentCapacity <= 0) {
			this.currentCapacity = 0;
			shutDown();
			return;
		}

		updateStatus();
	}

	// Thruster abschalten: kein Schub, keine Geschwindigkeit, Status CRITICAL
	private void shutDown() {
		this.thrust = 0;
		this.velocity = 0;
		super.status = Status.EMPTY;
	}
	
	// Status je nach Treibstoff-Füllstand setzen
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
	public double getConsumptionRate() {
		return consumptionRate;
	}

	public double getThrust() {
		return thrust;
	}

	public double getVelocity() {
		return velocity;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

	public double getCurrentCapacity() {
		return currentCapacity;
	}

	// Setter
	public void setConsumptionRate(double consumptionRate) {
		this.consumptionRate = consumptionRate;
	}

	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setCurrentCapacity(double currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		return "Thruster [thrust=" + thrust + ", velocity=" + velocity
				+ ", currentCapacity=" + currentCapacity + "/" + maxCapacity
				+ ", status=" + super.status + "]";
	}
}