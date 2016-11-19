package benoitd.com.biffyclyrotour;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import benoitd.com.biffyclyrotour.BandInTownAPI.BandInTown;
import benoitd.com.biffyclyrotour.RecyclerViewAdapter.EventAdapter;
import benoitd.com.biffyclyrotour.BandInTownAPI.InterfaceBandInTown;
import benoitd.com.biffyclyrotour.Model.Event;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class AllTourDates extends AppCompatActivity {

    private List<Event> mEvents;
    private EventAdapter mAdapter;
    private CollapsingToolbarLayout ctlLayout;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tour_dates);

        // Ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4366233206286319/1046868049");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                //requestNewInterstitial();
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mInterstitialAd.show();
            }
        });

        requestNewInterstitial();
        System.out.println(mInterstitialAd.isLoaded());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }


        // Layout
        ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(this.getString(R.string.app_name));

        RecyclerView eventRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mEvents = new ArrayList<Event>();
        mAdapter = new EventAdapter(mEvents, this.getBaseContext());

        eventRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        eventRecyclerView.setAdapter(mAdapter);

        InterfaceBandInTown serviceWeb = BandInTown.getService();
        serviceWeb.allEvents(new Callback<List<Event>>() {
            @Override
            public void success(List<Event> events, Response response) {
                mEvents.clear();
                mEvents.addAll(events);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("Error is " + error);
            }
        });
    }


    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("XXX")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tour_dates, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}