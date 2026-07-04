package astro.path.objects;

import java.util.List;
import java.util.ArrayList;

public class SpaceShart {
	String name;
	List<SCFart> SCPList;
	
	public String getName() {
		return name;
	}
	public List<SCFart> getSCPList() {
		return SCPList;
	}
	public void addSCPart(SCFart SCP) {
		SCPList.add(SCP);
	}
	// TODO  implement removing SCPart(s)
	
	public SpaceShart(){
		SCPList = new ArrayList<SCFart>();
	}
	public SpaceShart(String name) {
		this.SCPList = new ArrayList<SCFart>();
		this.name = name;
	}
}
