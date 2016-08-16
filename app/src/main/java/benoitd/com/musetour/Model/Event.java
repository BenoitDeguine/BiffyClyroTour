package benoitd.com.musetour.Model;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Benoit on 13/12/15.
 */
public class Event {

    @SerializedName("id")
    private int eId;

    @SerializedName("title")
    private String eTitle;

    @SerializedName("datetime")
    private String eDate;

    private Date eDateFormat;

    @SerializedName("venue")
    private Venue eVenue;

    public Event(int eId, String eTitle, String eDate, Venue eVenue) {
        this.eId = eId;
        this.eTitle = eTitle;
        this.eDate = eDate;
        this.eVenue = eVenue;
     }

    public int geteId() {
        return eId;
    }

    public String geteTitle() {
        return eTitle;
    }

    public String geteDate() {
        return eDate;
    }

    public Venue geteVenue() {
        return eVenue;
    }

    public void seteDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date date = format.parse(this.eDate);
            this.eDateFormat = date;
        } catch (ParseException e) {
        }
    }

    public Date geteDateFormat() {
        return eDateFormat;
    }

    public String getMonth() {
        return (String) android.text.format.DateFormat.format("MMM", this.eDateFormat);
    }

    public String getDay() {
        return (String) android.text.format.DateFormat.format("dd", this.eDateFormat);
    }
}
