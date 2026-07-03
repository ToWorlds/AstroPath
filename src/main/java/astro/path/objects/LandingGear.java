package astro.path.objects;

public class LandingGear extends SCPart {
	double health;
	double maxHealth;
	double damagePerUse;
	boolean isDeployed;

	// Standard-Konstruktor: alles auf 0, eingefahren, Status OK
	public LandingGear() {
		this.health = 0.0;
		this.maxHealth = 0.0;
		this.damagePerUse = 0.0;
		this.isDeployed = false;
		super.status = Status.OK;
	}

	// Konstruktor mit echten Werten
	public LandingGear(double maxHealth, double damagePerUse) {
		this.maxHealth = maxHealth;
		this.health = maxHealth; // startet mit voller Gesundheit
		this.damagePerUse = damagePerUse;
		this.isDeployed = false;
		updateStatus();
	}

	// Fahrwerk ausfahren
	public void deploy() {
		if (health <= 0) {
			super.status = Status.EMPTY;
			return; // kaputtes Fahrwerk lässt sich nicht ausfahren
		}
		this.isDeployed = true;
		applyWear();
	}

	// Fahrwerk einfahren
	public void retract() {
		if (health <= 0) {
			super.status = Status.OFFLINE;
			return;
		}
		this.isDeployed = false;
		applyWear();
	}

	// Verschleiß bei jeder Benutzung
	private void applyWear() {
		this.health = this.health - this.damagePerUse;
		if (this.health < 0) {
			this.health = 0;
		}
		updateStatus();
	}

	// Status je nach Gesundheitszustand setzen (prozentual)
	private void updateStatus() {
		if (this.health <= 0) {
			super.status = Status.OFFLINE;
		} else if (this.health <= this.maxHealth * 0.1) {
			super.status = Status.CRITICAL;
		} else if (this.health <= this.maxHealth * 0.2) {
			super.status = Status.WARNING;
		} else {
			super.status = Status.OK;
		}
	}

	// Getter
	public double getHealth() {
		return health;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getDamagePerUse() {
		return damagePerUse;
	}

	public boolean isDeployed() {
		return isDeployed;
	}

	// Setter
	public void setHealth(double health) {
		this.health = health;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setDamagePerUse(double damagePerUse) {
		this.damagePerUse = damagePerUse;
	}

	public void setDeployed(boolean isDeployed) {
		this.isDeployed = isDeployed;
	}

	@Override
	public String toString() {
		return "LandingGear [health=" + health + "/" + maxHealth
				+ ", deployed=" + isDeployed
				+ ", status=" + super.status + "]";
	}
}