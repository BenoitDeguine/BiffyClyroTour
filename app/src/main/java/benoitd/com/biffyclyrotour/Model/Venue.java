package benoitd.com.biffyclyrotour.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Benoit on 13/12/15.
 */
public class Venue {

    @SerializedName("name")
    private String vName;

    @SerializedName("city")
    private String vCity;

    @SerializedName("region")
    private String vRegion;

    @SerializedName("country")
    private String vCountry;

    @SerializedName("latitude")
    private Float vLatitude;

    @SerializedName("longitude")
    private Float vLongitude;

    public Venue(String vName, String vCity, String vRegion, String vCountry, Float vLatitude, Float vLongitude) {
        this.vName = vName;
        this.vCity = vCity;
        this.vRegion = vRegion;
        this.vCountry = vCountry;
        this.vLatitude = vLatitude;
        this.vLongitude = vLongitude;
    }

    public String getvName() {
        return vName;
    }

    public String getvCity() {
        return vCity;
    }

    public String getvRegion() {
        return vRegion;
    }

    public String getvCountry() {
        return vCountry;
    }

    public Float getvLatitude() {
        return vLatitude;
    }

    public Float getvLongitude() {
        return vLongitude;
    }
}
