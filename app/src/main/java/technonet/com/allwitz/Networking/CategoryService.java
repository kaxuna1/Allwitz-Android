package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import technonet.com.allwitz.Models.Category;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public interface CategoryService {
    @GET("topcategoriesmobile")
    Observable<List<Category>> topCategories();
    @GET("categories")
    Observable<List<Category>> categories();


}
