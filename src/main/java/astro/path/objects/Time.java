package astro.path.objects;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
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
}
