package com.example.MusicApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicApplication.entities.Songs;
import com.example.MusicApplication.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService{
@Autowired
SongsRepository srepo;
	@Override
	public String addSongs(Songs song) {
		srepo.save(song);
		return "Song is Added";
	}
	@Override
	public boolean songexist(String name) {
		Songs song=srepo.findByName(name);
		if(song==null) {
			return false;
		}else {
		return true;
	}

}
	@Override
	public List<Songs> fetchAllSongs() {
List<Songs> songlist=srepo.findAll();
		return songlist;
	}
	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
		
	}
}