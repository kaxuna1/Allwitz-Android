package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import technonet.com.allwitz.Models.Category;
import technonet.com.allwitz.Models.GalleryPicture;
import technonet.com.allwitz.Models.Page;
import technonet.com.allwitz.Models.Session;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class OnlineData {
    public static Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.43.168:8080/")
            .build();
    public static void login(String email,String password,final Action1<Session> onSession){


        Observable<Session> sessionObservable = retrofit.create(SessionService.class)
                .loginEmail(email, password);
        try{
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError(new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Session>() {
                        @Override
                        public void call(Session session) {
                            onSession.call(session);
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void topCategories(final Action1<List<Category>> onCategories){
        Observable<List<Category>> sessionObservable = retrofit.create(CategoryService.class)
                .topCategories();
        try{
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError(throwable -> throwable.printStackTrace())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(categories -> onCategories.call(categories));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void userGallery(long user, int page, Action1<Page<GalleryPicture>> action1){
        Observable<Page<GalleryPicture>> observable = retrofit.create(GalleryPictureService.class)
                .userGallery(user,page);
        try{
            observable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError(Throwable::printStackTrace)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(action1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
