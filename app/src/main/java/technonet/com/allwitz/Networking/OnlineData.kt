package technonet.com.allwitz.Networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import technonet.com.allwitz.Models.*
import technonet.com.allwitz.Static.Variables

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

object OnlineData {
    var retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Variables.url)
            .build()

    fun login(email: String, password: String, onSession: Action1<Session>) {


        val sessionObservable = retrofit.create<SessionService>(SessionService::class.java!!)
                .loginEmail(email, password)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { throwable -> throwable.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { session -> onSession.call(session) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun topCategories(onCategories: Action1<List<Category>>) {
        val sessionObservable = retrofit.create<CategoryService>(CategoryService::class.java!!)
                .topCategories()
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(onCategories)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun categories(onCategories: Action1<List<Category>>) {

        val sessionObservable = retrofit.create<CategoryService>(CategoryService::class.java!!)
                .categories()
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { onCategories.call(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun userGallery(user: Long, page: Int, action1: Action1<Page<GalleryPicture>>) {
        val observable = retrofit.create<GalleryPictureService>(GalleryPictureService::class.java!!)
                .userGallery(user, page)
        try {
            observable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(action1)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun cities(callback: Action1<List<City>>) {
        val sessionObservable = retrofit.create<CityService>(CityService::class.java!!)
                .cities()
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun orders(page: Int, callback: Action1<Page<Order>>) {
        val sessionObservable = retrofit.create<OrderService>(OrderService::class.java!!)
                .orders(page)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun permissions(callback: Action1<List<Permission>>) {
        val sessionObservable = retrofit.create<PermissionService>(PermissionService::class.java!!)
                .permissions()
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun strings(callback: Action1<Map<String, String>>) {
        val sessionObservable = retrofit.create<StringsService>(StringsService::class.java!!)
                .strings()
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun categoryJoinSchedule(cat: Long, callback: Action1<List<Schedule>>) {
        val sessionObservable = retrofit.create<ScheduleService>(ScheduleService::class.java!!)
                .categoryJoinSchedule(cat)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun scheduledTimes(id: Long, callback: Action1<List<ScheduleTime>>) {
        val sessionObservable = retrofit.create<ScheduleService>(ScheduleService::class.java!!)
                .scheduledTimes(id)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun scheduleForDays(id: Long, days: Int, callback: Action1<List<FreeInterval>>) {
        val sessionObservable = retrofit.create<ScheduleService>(ScheduleService::class.java!!)
                .scheduleForDays(id, days)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun scheduledTimeForLesson(id: Long, cat: Long, days: Int, callback: Action1<List<BookedTime>>) {
        val sessionObservable = retrofit.create<ScheduleService>(ScheduleService::class.java!!)
                .scheduledTimeForLesson(id, cat, days)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun scheduledTimeForUser(id: Long, days: Int, callback: Action1<List<BookedTime>>) {
        val sessionObservable = retrofit.create<ScheduleService>(ScheduleService::class.java)
                .scheduledTimeForUser(id, days)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun search(cat: Long, city: Long, page: Int, callback: Action1<Page<UserCategoryJoin>>) {
        val sessionObservable = retrofit.create<SearchService>(SearchService::class.java)
                .search(page, cat, city)
        try {
            sessionObservable
                    .subscribeOn(Schedulers.newThread())
                    .doOnError { it.printStackTrace() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
