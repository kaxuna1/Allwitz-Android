package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class Category {
    private long id;

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private String name;

    private String uuid;

    public Category(){}
}
