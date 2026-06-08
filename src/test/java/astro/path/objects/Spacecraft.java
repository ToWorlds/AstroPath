package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class Spacecraft {
	String name;
	List<SCPart> SCPList;
	
	public String getName() {
		return name;
	}
	public List<SCPart> getSCPList() {
		return SCPList;
	}
	public void addSCPart(SCPart SCP) {
		SCPList.add(SCP);
	}
	// TODO  implement removing SCPart(s)
	
	public Spacecraft(){
		SCPList = new ArrayList<SCPart>();
	}
	public Spacecraft(String name) {
		this.SCPList = new ArrayList<SCPart>();
		this.name = name;
	}
}
