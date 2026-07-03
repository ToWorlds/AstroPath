package astro.path.objects;

public class Sensor extends SCPart {
	double maxDataCapacity;
	double currentCapacityUsed;
	double dataCollectionRate;
	double dataTransmissionRate;
	double powerUsage;

	// Standard-Konstruktor: alles auf 0, Status OK
	public Sensor() {
		this.maxDataCapacity = 0.0;
		this.currentCapacityUsed = 0.0;
		this.dataCollectionRate = 0.0;
		this.dataTransmissionRate = 0.0;
		this.powerUsage = 0.0;
		super.status = Status.OK;
	}

	// Konstruktor mit echten Werten
	public Sensor(double maxDataCapacity, double dataCollectionRate,
			double dataTransmissionRate, double powerUsage) {
		this.maxDataCapacity = maxDataCapacity;
		this.currentCapacityUsed = 0.0; // startet mit leerem Datenspeicher
		this.dataCollectionRate = dataCollectionRate;
		this.dataTransmissionRate = dataTransmissionRate;
		this.powerUsage = powerUsage;
		super.status = Status.OK;
	}

	// Der Sensor arbeitet: sammelt Daten und sendet welche
	public void operate() {
		// neue Daten sammeln
		this.currentCapacityUsed = this.currentCapacityUsed + this.dataCollectionRate;
		// Daten senden (Speicher wird wieder frei)
		this.currentCapacityUsed = this.currentCapacityUsed - this.dataTransmissionRate;

		// Speicher kann nicht unter 0 fallen
		if (this.currentCapacityUsed < 0) {
			this.currentCapacityUsed = 0;
		}
		// Speicher kann nicht über das Maximum steigen (Datenstau)
		if (this.currentCapacityUsed > this.maxDataCapacity) {
			this.currentCapacityUsed = this.maxDataCapacity;
		}

		updateStatus();
	}

	// Status je nach Füllstand des Datenspeichers (voll = schlecht)
	private void updateStatus() {
		if (this.currentCapacityUsed >= this.maxDataCapacity) {
			super.status = Status.CRITICAL; // Speicher voll: Datenstau
		} else if (this.currentCapacityUsed >= this.maxDataCapacity * 0.8) {
			super.status = Status.WARNING; // fast voll
		} else {
			super.status = Status.OK;
		}
	}

	// Getter
	public double getMaxDataCapacity() {
		return maxDataCapacity;
	}

	public double getCurrentCapacityUsed() {
		return currentCapacityUsed;
	}

	public double getDataCollectionRate() {
		return dataCollectionRate;
	}

	public double getDataTransmissionRate() {
		return dataTransmissionRate;
	}

	public double getPowerUsage() {
		return powerUsage;
	}

	// Setter
	public void setMaxDataCapacity(double maxDataCapacity) {
		this.maxDataCapacity = maxDataCapacity;
	}

	public void setCurrentCapacityUsed(double currentCapacityUsed) {
		this.currentCapacityUsed = currentCapacityUsed;
	}

	public void setDataCollectionRate(double dataCollectionRate) {
		this.dataCollectionRate = dataCollectionRate;
	}

	public void setDataTransmissionRate(double dataTransmissionRate) {
		this.dataTransmissionRate = dataTransmissionRate;
	}

	public void setPowerUsage(double powerUsage) {
		this.powerUsage = powerUsage;
	}

	@Override
	public String toString() {
		return "Sensor [dataUsed=" + currentCapacityUsed + "/" + maxDataCapacity
				+ ", collect=" + dataCollectionRate + ", transmit=" + dataTransmissionRate
				+ ", status=" + super.status + "]";
	}
}