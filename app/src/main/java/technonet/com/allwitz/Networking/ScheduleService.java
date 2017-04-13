package technonet.com.allwitz.Networking;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import technonet.com.allwitz.Models.FreeInterval;
import technonet.com.allwitz.Models.Schedule;
import technonet.com.allwitz.Models.ScheduleTime;
import technonet.com.allwitz.Models.BookedTime;

/**
 * Created by vakhtanggelashvili on 4/13/17.
 */

public interface ScheduleService {
    @GET("getusercategoryscheduledays/{category}")
    Observable<List<Schedule>> categoryJoinSchedule(@Path("category") long category);

    @GET("scheduledtimes/{id}")
    Observable<List<ScheduleTime>> scheduledTimes(@Path("id") long id);


    @GET("schedulefordays/{id}/{days}")
    Observable<List<FreeInterval>> scheduleForDays(@Path("id") long id,@Path("days") int days);

    @GET("getscheduledtimeforlesson/{id}/{cat}/{days}")
    Observable<List<BookedTime>> scheduledTimeForLesson(@Path("id") long id,@Path("cat") int cat,@Path("days") int days);

    @GET("getscheduledtimeforuser/{id}/{days}")
    Observable<List<BookedTime>> scheduledTimeForUser(@Path("id") long id,@Path("days") int days);
}
