package astro.path.objects;

public abstract class SCPart {
	enum Status {OK, WARNING, CRITICAL};
	Status status;
	
	public Status getStatus() {
		return this.status;
	}

}
