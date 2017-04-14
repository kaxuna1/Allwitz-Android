package technonet.com.allwitz.Networking;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import technonet.com.allwitz.Models.Page;
import technonet.com.allwitz.Models.UserCategoryJoin;

/**
 * Created by vakhtanggelashvili on 4/14/17.
 */

public interface SearchService {
    @GET("search/{cat}/{city}/{page}")
     Observable<Page<UserCategoryJoin>> search( @Path(value = "page") int page,
                                                      @Path(value = "category") long cat,
                                                      @Path(value = "city") long city);
}
