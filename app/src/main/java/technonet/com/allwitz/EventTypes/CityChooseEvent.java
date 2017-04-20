package technonet.com.allwitz.EventTypes;

/**
 * Created by vakhtanggelashvili on 4/20/17.
 */

public class CityChooseEvent {
    public final String name;
    public final long id;

    public CityChooseEvent(String name, long id) {
        this.name = name;
        this.id = id;
    }
}
