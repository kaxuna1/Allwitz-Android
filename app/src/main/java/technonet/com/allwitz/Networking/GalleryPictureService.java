package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import technonet.com.allwitz.Models.GalleryPicture;
import technonet.com.allwitz.Models.Page;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public interface GalleryPictureService {
    @GET("listgallery/{id}/{page}")
    Observable<Page<GalleryPicture>> userGallery(@Path("id") long id,@Path("page") int page);
}
