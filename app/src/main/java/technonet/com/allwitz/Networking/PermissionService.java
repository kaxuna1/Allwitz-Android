package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import technonet.com.allwitz.Models.Permission;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public interface PermissionService {
    @GET("getpermissions")
    Observable<List<Permission>> permissions();
}
