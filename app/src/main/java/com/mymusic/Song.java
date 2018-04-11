package com.mymusic;

/**
 * Created by meri on 4/2/2018.
 */

public class Song {

    private String songTitle;
    private String artistName;
    private int imageAlbumId;

    /*
     * Create a new Song object.
     *
     * @param imageAlbumId is drawable reference ID that corresponds to the album
     * @param artistName is the name of the artist (e.g. Adele)
     * @param songTitle is the corresponding song title (e.g Skyfall)
     **/
    public Song(int imageAlbumId, String songTitle, String artistName) {
        this.imageAlbumId = imageAlbumId;
        this.songTitle = songTitle;
        this.artistName = artistName;
    }

    public int getImageAlbumId() {
        return imageAlbumId;
    }

    public void setImageAlbumId(int imageAlbumId) {
        this.imageAlbumId = imageAlbumId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
