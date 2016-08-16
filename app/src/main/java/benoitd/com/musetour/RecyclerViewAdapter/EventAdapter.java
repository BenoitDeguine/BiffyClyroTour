package benoitd.com.musetour.RecyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import benoitd.com.musetour.Model.Event;
import benoitd.com.musetour.R;

import static android.provider.Settings.Global.getString;

/**
 * Created by Benoit on 13/12/15.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> mEvent;
    private Context mContext;
    Date date = new Date();

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView eventName;
        private final TextView eventCity;
        private final TextView eventMonth;
        private final TextView eventDay;
        private final TextView eventCountdown;

        public ViewHolder(View v) {
            super(v);
            eventName = (TextView) v.findViewById(R.id.event_name);
            eventCity = (TextView) v.findViewById(R.id.event_city);
            eventMonth = (TextView) v.findViewById(R.id.month);
            eventDay = (TextView) v.findViewById(R.id.day);
            eventCountdown = (TextView) v.findViewById(R.id.countdown);
        }
    }

    public EventAdapter(List<Event> mEvent, Context mContext) {
        this.mEvent = mEvent;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event currentEvent = mEvent.get(position);

        holder.eventName.setText(currentEvent.geteVenue().getvName());
        holder.eventCity.setText(currentEvent.geteVenue().getvCity() + ", " + currentEvent.geteVenue().getvCountry());

        // On initialise la date
        currentEvent.seteDateFormat();
        holder.eventMonth.setText(currentEvent.getMonth());
        holder.eventDay.setText(currentEvent.getDay());
        holder.eventCountdown.setText(printDifference(date, currentEvent.geteDateFormat()));

    }


    public String printDifference(Date startDate, Date endDate) {

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        if (elapsedDays > 0) {
            if (elapsedDays > 1) {
                return elapsedDays + " days";
            } else {
                return elapsedDays  + " day";
            }
        } else if (elapsedHours > 0) {
            if (elapsedHours > 1) {
                return elapsedHours  + " hours";
            } else {
                return elapsedHours  + " hours";
            }
        } else {
            return "Now";
        }

    }

    @Override
    public int getItemCount() {
        return mEvent.size();
    }
}
