package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class Session {
    public Session(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    private long id;
    private long userId;
    private boolean isactive;
    private int lang;

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }
}
