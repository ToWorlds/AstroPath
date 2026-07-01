package astro.path;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.time.Duration;

public class SimpleTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        // Schedule a task to run every 1 second (1000 ms)
        LocalDateTime StartTimeStamp = java.time.LocalDateTime.now();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	LocalDateTime NowTimeStamp = java.time.LocalDateTime.now();
            	long yearsDiff = ChronoUnit.YEARS.between(StartTimeStamp, NowTimeStamp);
            	long daysDiff = ChronoUnit.DAYS.between(StartTimeStamp, NowTimeStamp);
            	long hoursDiff = ChronoUnit.HOURS.between(StartTimeStamp, NowTimeStamp);
                long minutesDiff = ChronoUnit.MINUTES.between(StartTimeStamp, NowTimeStamp);
            	long secondDiff = ChronoUnit.SECONDS.between(StartTimeStamp, NowTimeStamp);
                //Duration duration = Duration.between(StartTimeStamp, NowTimeStamp);
                System.out.println("Years\t:\tDays\t:\tHours\t:\tMinutes\t:\tSeconds");
                System.out.print(yearsDiff + "\t:\t");
                System.out.print(daysDiff + "\t:\t");
                System.out.print(hoursDiff + "\t:\t");
                System.out.print(minutesDiff + "\t:\t");
                System.out.println(secondDiff);
            }
        }, 0, 1000); // delay 0, period 1000ms

        // Stop timer after 5 seconds
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        timer.cancel();
    }
}