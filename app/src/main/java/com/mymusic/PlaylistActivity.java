package com.mymusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Create an list of Song objects
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(new Song( R.drawable.the_end_album,getText(R.string.i_gotta_feeling).toString(),
                getText(R.string.black_eyed_peas).toString()));

        // Create an SongAdapter, whose data source is a list of
        // songs. The adapter knows how to create list item views for each item
        // in the list.
        SongAdapter songAdapter = new SongAdapter(this, songList);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_playlist);
        listView.setAdapter(songAdapter);
    }

}
