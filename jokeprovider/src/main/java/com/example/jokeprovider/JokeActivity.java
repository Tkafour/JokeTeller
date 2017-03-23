package com.example.jokeprovider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_RESULT = "Joke Result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);


        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_RESULT);

        Button mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView mJokeText = (TextView) findViewById(R.id.joke_activity_text);
        mJokeText.setText(joke);

    }

}
