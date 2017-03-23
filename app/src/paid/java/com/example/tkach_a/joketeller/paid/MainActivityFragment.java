package com.example.tkach_a.joketeller.paid;


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


public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.onTaskCompleted {


    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);

        Button mJokeButton = (Button) v.findViewById(R.id.joke_button);

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });


        return v;
    }

    private void loadData() {

    EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), this);
    endpointsAsyncTask.execute();
    }

    @Override
    public void onTaskCompleted(String result) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_RESULT, result);
        startActivity(intent);
    }

}
