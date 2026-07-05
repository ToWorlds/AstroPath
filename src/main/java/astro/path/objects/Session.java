package astro.path.objects;

import java.util.List;
import java.util.ArrayList;
import java.time.Duration;

public class Session {
	public List<Mission> missionList;
	public Time oldTime;
	public Time currentTime;
	public String name;
	public String id;
	
	public Session(){
		this.missionList = new ArrayList<Mission>();
		this.currentTime = new Time();
		this.id = "0";
		this.name = "";
	}

}
