package astro.path.objects;


public class SCPart {
	public String SCID;
	public enum Status {OK, WARNING, CRITICAL};
	public Status status;
	
	public Status getStatus() {
		return this.status;
	}
}
