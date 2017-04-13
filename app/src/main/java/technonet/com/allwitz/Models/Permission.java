package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public class Permission {
    private long id;


    private String name;


    private String code;

    public Permission() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
