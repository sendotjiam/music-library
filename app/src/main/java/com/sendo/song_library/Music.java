package com.sendo.song_library;

public class Music {

    private String musicTitle;
    private String musicMaker;

    public Music(String musicTitle, String musicMaker) {
        this.musicTitle = musicTitle;
        this.musicMaker = musicMaker;
    }

    public Music() {

    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicMaker() {
        return musicMaker;
    }

    public void setMusicMaker(String musicMaker) {
        this.musicMaker = musicMaker;
    }
}
