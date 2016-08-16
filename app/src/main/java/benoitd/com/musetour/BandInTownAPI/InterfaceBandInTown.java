package benoitd.com.musetour.BandInTownAPI;

import java.util.List;

import benoitd.com.musetour.Model.Event;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Benoit on 13/12/15.
 */
public interface InterfaceBandInTown {

    String API_ID = "KEY_API";

    @GET("/?secret_key="+API_ID)
    void allEvents(Callback<List<Event>> callback);

}
