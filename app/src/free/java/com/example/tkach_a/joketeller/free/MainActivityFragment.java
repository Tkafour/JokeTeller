package com.example.tkach_a.joketeller.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.jokeprovider.JokeActivity;
import com.example.tkach_a.joketeller.EndpointsAsyncTask;
import com.example.tkach_a.joketeller.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.onTaskCompleted {

    private Button mJokeButton;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;



    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        setRetainInstance(true);

        mJokeButton = (Button) v.findViewById(R.id.joke_button);


        mAdView = (AdView) v.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.banner_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitialAdd();
                loadData();
            }
        });

        requestNewInterstitialAdd();

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else{
                    loadData();
                }
            }
        });




        return v;
    }

    public void loadData() {

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), this);
        endpointsAsyncTask.execute();
    }

    @Override
    public void onTaskCompleted(String result) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_RESULT, result);
        startActivity(intent);
    }

    public void requestNewInterstitialAdd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

}
