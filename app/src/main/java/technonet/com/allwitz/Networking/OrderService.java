package technonet.com.allwitz.Networking;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import technonet.com.allwitz.Models.Order;
import technonet.com.allwitz.Models.Page;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public interface OrderService {

    @GET("orders/{page}")
    Observable<Page<Order>> orders(@Path("page") int page);
}
