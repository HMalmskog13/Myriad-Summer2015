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
    @POST("/subscribe")
    void sendEmail(@Body Email email);


    @GET("/kingdoms")
    List<Place> placeList ();
   //get list of kingdoms

    //get list of quests for kingdom
    @GET("/kingdoms/{id}")
    List<Task> taskList (@Path("id") int id);
}
