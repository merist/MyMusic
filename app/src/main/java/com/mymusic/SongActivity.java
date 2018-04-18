package com.mymusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int songId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        ImageButton btnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        ImageButton btnStop = (ImageButton) findViewById(R.id.buttonStop);

        Intent intent = getIntent();
        String artistName = intent.getStringExtra("artistName");
        String songTitle = intent.getStringExtra("songTitle");
        String imageId = intent.getStringExtra("imageId");

        TextView songTextView = (TextView) findViewById(R.id.songTitleId);
        songTextView.setText(songTitle);
        TextView artistTextView = (TextView) findViewById(R.id.artistId);
        artistTextView.setText(artistName);
        ImageView imageView = findViewById(R.id.imageId);

        if (imageId != null) {
            imageView.setImageResource(Integer.valueOf(imageId));
        }
    }
}