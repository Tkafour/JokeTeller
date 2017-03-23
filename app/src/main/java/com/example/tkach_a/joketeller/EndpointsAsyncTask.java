package com.example.tkach_a.joketeller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.tkach_a.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private onTaskCompleted mTaskListener;
    private Context mContext;

    private ProgressDialog progress;

    public EndpointsAsyncTask(Activity activity) {

    }

    public EndpointsAsyncTask(Context context, onTaskCompleted listener) {
        this.mTaskListener = listener;
        this.mContext = context;
    }


    public interface onTaskCompleted {
        void onTaskCompleted(String result);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = ProgressDialog.show(mContext, null, mContext.getString(R.string.loading_dialog), true);

    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-159413.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        progress.dismiss();
        mTaskListener.onTaskCompleted(result);
    }
}
