package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title,duration));
            return true;
        }else
            return false;
    }
    private Song findSong(String title) {
        for (Song checkedSong: this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlists) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index < this.songs.size())) {
            playlists.add(this.songs.get(index));
            return true;
        }else {
            System.out.println("This album does not have track " + trackNumber);
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playLists) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playLists.add(checkedSong);
            return true;
        } else {
            System.out.println("This song " + title + " is not in album");
            return false;
        }

    }
}

