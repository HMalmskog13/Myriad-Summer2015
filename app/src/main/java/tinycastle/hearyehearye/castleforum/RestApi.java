package tinycastle.hearyehearye.castleforum;



import retrofit.http.Body;
import retrofit.http.POST;

/**
 *
 * Created by Heather on 3/17/2015.
 */
public interface RestApi {
    @POST("/email/")
    void sendEmail(@Body Email email);

}
