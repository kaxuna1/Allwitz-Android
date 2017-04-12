package technonet.com.allwitz.Models;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.sql.Time;
import java.util.Date;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class FreeInterval {
    private Date start;
    private Date end;

    public FreeInterval(Time start, Time end, Date date) {
        this.start = new DateTime(date).withHourOfDay(start.getHours()).withMinuteOfHour(start.getMinutes()).toDate();
        this.end = new DateTime(date).withHourOfDay(end.getHours()).withMinuteOfHour(end.getMinutes()).toDate();
    }
    public FreeInterval(){

    }

    public Date getStarting_time() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnding_time() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Duration getDuration(){
        return new Duration(this.getStarting_time().getTime(),this.getEnding_time().getTime());
    }
    public String getDurationString(){
        String durationString="";
        long hours=getDuration().getStandardHours();
        long minutes=(getDuration().getStandardMinutes()-(60*hours));
        return (hours>0?hours+" სთ. ":"")+minutes+" წთ";
    }

}
