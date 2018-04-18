package com.mymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView danceTextView = (TextView)findViewById(R.id.dance_category);
        danceTextView.setOnClickListener(this);

        TextView rockTextView = (TextView)findViewById(R.id.rock_category);
        rockTextView.setOnClickListener(this);

        TextView jazzTextView = (TextView)findViewById(R.id.jazz_category);
        jazzTextView.setOnClickListener(this);

        TextView latinTextView = (TextView)findViewById(R.id.latin_category);
        latinTextView.setOnClickListener(this);

        TextView hipHopTextView = (TextView)findViewById(R.id.hiphop_category);
        hipHopTextView.setOnClickListener(this);
    }

            @Override
            public void onClick(View view){
                String musicCategory;

                switch (view.getId()) {
                    case R.id.dance_category:
                        musicCategory = Constants.DANCE_CATEGORY;
                        break;
                     case R.id.rock_category:
                         musicCategory = Constants.ROCK_CATEGORY;
                    break;
                    case R.id.jazz_category:
                        musicCategory = Constants.JAZZ_CATEGORY;
                        break;
                    case R.id.latin_category:
                        musicCategory = Constants.LATIN_CATEGORY;
                        break;
                    case R.id.hiphop_category:
                        musicCategory = Constants.HIPHOP_CATEGORY;
                        break;
                    default:
                        throw new IllegalStateException("Not a valid text view ID");
                }
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                intent.putExtra(Constants.EXTRA_MUSIC_CATEGORY, musicCategory);
                startActivity(intent);

    }
}