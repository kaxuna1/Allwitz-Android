package technonet.com.allwitz.EventTypes;

/**
 * Created by vakhtanggelashvili on 4/15/17.
 */

public class ClassChooseEvent {
    public final String name;
    public final long id;

    public ClassChooseEvent(String name, long id) {
        this.name = name;
        this.id = id;
    }
}
