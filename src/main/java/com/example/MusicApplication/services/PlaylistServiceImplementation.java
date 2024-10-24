package com.example.MusicApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicApplication.entities.Playlist;
import com.example.MusicApplication.repositories.PlaylistRepository;
@Service 
public class PlaylistServiceImplementation implements PlaylistService{
	@Autowired
	PlaylistRepository prepo;

	@Override
	public void addPlaylist(Playlist playlist) {
	prepo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchPlaylists() {
		
		return prepo.findAll();
	}
	

}
