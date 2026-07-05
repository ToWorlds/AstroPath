package astro.path.objects;


public class SCPart {
	public String SCID;
	public enum Status {OK, WARNING, CRITICAL, EMPTY, OFFLINE};
	public Status status;
	public String name;
	
	public Status getStatus() {
		return this.status;
	}
}
