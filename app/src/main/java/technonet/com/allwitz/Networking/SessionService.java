package technonet.com.allwitz.Networking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import technonet.com.allwitz.Models.EmailLoginRequestBody;
import technonet.com.allwitz.Models.Session;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public interface SessionService {
    @FormUrlEncoded
    @POST("loginmobileapi")
    Observable<Session> loginEmail(@Field("email") String email, @Field("password") String password);
}
