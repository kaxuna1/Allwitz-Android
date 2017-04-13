package technonet.com.allwitz.Models;

import java.sql.Time;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public class ScheduleTime {
    private long id;

    private Time startTime;

    private Time endTime;

    private Schedule schedule;

    private boolean active;

    public ScheduleTime() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
