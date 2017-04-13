package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public class Schedule {
    private long id;
    private UserCategoryJoin userCategoryJoin;
    private boolean active;
    private int dayOfWeek;

    public Schedule() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserCategoryJoin getUserCategoryJoin() {
        return userCategoryJoin;
    }

    public void setUserCategoryJoin(UserCategoryJoin userCategoryJoin) {
        this.userCategoryJoin = userCategoryJoin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
