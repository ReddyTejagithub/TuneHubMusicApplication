package com.example.MusicApplication.services;

import java.util.List;

import com.example.MusicApplication.entities.Songs;

public interface SongsService {
public String addSongs(Songs song);
public boolean songexist(String name);
public List<Songs> fetchAllSongs();
public void updateSong(Songs song);
}
