package technonet.com.allwitz.Networking;

import java.util.Map;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public interface StringsService {
    @GET("strings")
    public Observable<Map<String,String>> strings();
}
