package benoitd.com.biffyclyrotour.BandInTownAPI;

import retrofit.RestAdapter;

/**
 * Created by Benoit on 13/12/15.
 */
public class BandInTown {

    private static final String API_URL = "http://benoitdeguine.fr/api/biffyclyrotour";

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .build();

    private static final InterfaceBandInTown SERVICE = REST_ADAPTER.create(InterfaceBandInTown.class);

    public static InterfaceBandInTown getService() {
        return SERVICE;
    }

}
