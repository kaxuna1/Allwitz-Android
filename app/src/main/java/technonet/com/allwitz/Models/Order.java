package technonet.com.allwitz.Models;

import java.util.List;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class Order {
    private long id;

    private String uuid;

    private boolean confirmed;

    private List<BookedTime> bookedTimes;

    private float price;

}
