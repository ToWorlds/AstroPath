package astro.path.objects;

public class Time {

	public long seconds;
	
	public Time() {
		this.seconds = 0;
		}
	
	public long getTotalSeconds() {
		return seconds;
	}
	
	public long getDisplaySeconds() {
		return (seconds % 60);
	}
	
	public long getTotalMinutes() {
		return (seconds / 60);
	}
	
	public long getDisplayMinutes() {
		return ((getTotalMinutes()) % 60);
	}
	
	public long getTotalHours() {
		return (seconds / 3600);
	}
	
	public long getDisplayHours() {
		return (getTotalHours() % 24);
	}
	
	public long getTotalDays() {
		return (seconds / (3600 * 24));
	}
	
	public long getDisplayDays() {
		return (getTotalDays() % 365);
	}
	
	public long getTotalYears() {
		return (seconds / (3600 * 24 * 365));
	}
	
	public void setTime (long seconds) {
		this.seconds = seconds;
	}
	
	public void setTime (long years, long days, long hours, long minutes, long seconds) {
		long sum = 0;
		sum += seconds;
		sum += (minutes * 60);
		sum += (hours * 3600);
		sum += (days * 3600 * 24);
		sum += (years * 3600 * 24 * 365);
		this.seconds = sum;
	}

	public void addSeconds(long seconds) {
		this.seconds += seconds;
	}

	public void addMinutes(long minutes) {
		this.seconds += (minutes * 60);
	}

	public void addhours(long hours) {
		this.seconds += (hours * 3600);
	}

	public void addDays(long days) {
		this.seconds += (days * 3600 * 24);
	}

	public void addYears(long years) {
		this.seconds += (years * 3600 * 24 * 365);
	}
	/*
	long years;
	long days;
	long hours;
	long minutes;
	long seconds;
	LocalDateTime StartTimeStamp;
	
	
	public Time(){
		this.years = 0;
		this.days = 0;
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	//Bound to real time
	public void StartTime() {
		this.StartTimeStamp = java.time.LocalDateTime.now();
	}
	
	//Bound to real time
	public void UpdateTime() {	
		LocalDateTime NowTimeStamp = java.time.LocalDateTime.now();
    	this.years = ChronoUnit.YEARS.between(this.StartTimeStamp, NowTimeStamp);
    	this.days = ChronoUnit.DAYS.between(this.StartTimeStamp, NowTimeStamp);
    	this.hours = ChronoUnit.HOURS.between(this.StartTimeStamp, NowTimeStamp);
        this.minutes = ChronoUnit.MINUTES.between(this.StartTimeStamp, NowTimeStamp);
    	this.seconds = ChronoUnit.SECONDS.between(this.StartTimeStamp, NowTimeStamp);
	}
	
	public void PrintTime() {
		System.out.println("Years\t:\tDays\t:\tHours\t:\tMinutes\t:\tSeconds");
        System.out.print(this.years + "\t:\t");
        System.out.print(this.days + "\t:\t");
        System.out.print(this.hours + "\t:\t");
        System.out.print(this.minutes + "\t:\t");
        System.out.println(this.seconds);
	}

	public long getYears() {
		return years;
	}

	public long getDays() {
		return days;
	}

	public long getHours() {
		return hours;
	}

	public long getMinutes() {
		return minutes;
	}

	public long getSeconds() {
		return seconds;
	}

	public LocalDateTime getStartTimeStamp() {
		return StartTimeStamp;
	}
	public static void main(String[] args) {
		Time time = new Time();
		time.StartTime();
		try {
			for(int i = 0; i <= 5; i++) {
				time.UpdateTime();
				time.PrintTime();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {};
		
		
	}
	*/
}
