package com.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    // Create an list of Song objects
    ArrayList<Song> songList = new ArrayList<>();

    String musicCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Home button to return in the main screen
        ImageButton homeImageButton = (ImageButton) findViewById(R.id.home);
        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(PlaylistActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

        Intent intent = getIntent();
        musicCategory = intent.getStringExtra(Constants.EXTRA_MUSIC_CATEGORY);

        // Check category then populate the songList
        if (musicCategory.equals(Constants.DANCE_CATEGORY)) {
            songList.add(new Song(String.valueOf(R.drawable.black_eyed_peas), getText(R.string.i_gotta_feeling).toString(),
                    getText(R.string.black_eyed_peas).toString()));
            songList.add(new Song(String.valueOf(R.drawable.chainsmokers), getText(R.string.something_just_like_this).toString(),
                    getText(R.string.chainsmokers_coldplay).toString()));
            songList.add(new Song(String.valueOf(R.drawable.selena_gomez), getText(R.string.it_aint_me).toString(),
                    getText(R.string.kygo_selena_gomez).toString()));
            songList.add(new Song(String.valueOf(R.drawable.rihanna), getText(R.string.this_is_what_you_came_for).toString(),
                    getText(R.string.rihanna_harris).toString()));
        } else if (musicCategory.equals(Constants.ROCK_CATEGORY)) {
            songList.add(new Song(String.valueOf(R.drawable.bon_jovi), getText(R.string.livin_on_prayer).toString(),
                    getText(R.string.bon_jovi).toString()));
            songList.add(new Song(String.valueOf(R.drawable.imagine_dragons), getText(R.string.radioactive).toString(),
                    getText(R.string.imagine_dragons).toString()));
            songList.add(new Song(String.valueOf(R.drawable.nirvana), getText(R.string.smell_like_teen_spirit).toString(),
                    getText(R.string.nirvana).toString()));
            songList.add(new Song(String.valueOf(R.drawable.u2), getText(R.string.with_or_without_you).toString(),
                    getText(R.string.u2).toString()));
        } else if (musicCategory.equals(Constants.JAZZ_CATEGORY)) {
            songList.add(new Song(String.valueOf(R.drawable.louis_armstrong), getText(R.string.what_wonderful_world).toString(),
                    getText(R.string.louis_armstrong).toString()));
        } else if (musicCategory.equals(Constants.LATIN_CATEGORY)) {
            songList.add(new Song(String.valueOf(R.drawable.shakira), getText(R.string.la_tortura).toString(),
                    getText(R.string.shakira).toString()));
        } else {
            songList.add(new Song(String.valueOf(R.drawable.eminem), getText(R.string.stan).toString(),
                    getText(R.string.eminem).toString()));
        }

        // Create an SongAdapter, whose data source is a list of
        // songs. The adapter knows how to create list item views for each item
        // in the list.
        SongAdapter songAdapter = new SongAdapter(this, songList);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_playlist);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlaylistActivity.this, SongActivity.class);
                intent.putExtra("artistName", songList.get(position).getArtistName());
                intent.putExtra("songTitle", songList.get(position).getSongTitle());
                intent.putExtra("imageId", songList.get(position).getImageAlbumId());
                startActivity(intent);
            }
        });

    }
}
