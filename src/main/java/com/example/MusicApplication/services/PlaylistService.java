package com.example.MusicApplication.services;

import java.util.List;

import com.example.MusicApplication.entities.Playlist;

public interface PlaylistService {

public void addPlaylist(Playlist playlist);

public List<Playlist> fetchPlaylists();

}
