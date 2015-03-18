package tinycastle.hearyehearye.castleforum;




import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 *
 * Created by Heather on 3/17/2015.
 */
public interface RestApi {
    @POST("/email/")
    void sendEmail(@Body Email email);


    @GET("https://challenge2015.myriadapps.com/api/v1/kingdoms")
    void getKingdom();


    @GET("https://challenge2015.myriadapps.com/api/v1/kingdoms/{id}")
    void getTask(@Path("id")int kingdomId);
}
