package tinycastle.hearyehearye.castleforum;




import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 *
 * Created by Heather on 3/17/2015.
 */
public interface RestApi {
    @POST("https://challenge2015.myriadapps.com/api/v1/subscribe")
    void sendEmail(@Body Email email);


    @GET("https://challenge2015.myriadapps.com/api/v1/kingdoms")
    List<Place> placeList ();
   // void getKingdom();


    @GET("https://challenge2015.myriadapps.com/api/v1/kingdoms/{id}")
    List<Task> taskList (@Path("id") int id);
}
