package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import technonet.com.allwitz.Models.Category;
import technonet.com.allwitz.Models.City;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public interface CityService {
    @GET("cities")
    Observable<List<City>> cities();
}
