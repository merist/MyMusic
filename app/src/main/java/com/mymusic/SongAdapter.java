package com.mymusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by meri on 4/2/2018.
 */


public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * This is the custom constructor.
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_item.xml layout with the ID song_title
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.song_title);
        // Get the song title from the current Song object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the song_item.xml layout with the ID artist_name
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Song object and
        // set this text on the number TextView
        numberTextView.setText(currentSong.getArtistName());

        // Find the ImageView in the song_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Song object and
        // set the image to iconView
        iconView.setImageResource(Integer.valueOf(currentSong.getImageAlbumId()));

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
