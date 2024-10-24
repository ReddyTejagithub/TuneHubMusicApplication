package com.example.MusicApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MusicApplication.entities.Playlist;
import com.example.MusicApplication.entities.Songs;
import com.example.MusicApplication.services.PlaylistService;
import com.example.MusicApplication.services.SongsService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pserv;
	@Autowired
	SongsService sserv;
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		//fetching the songs using song service
		List<Songs> songlist=sserv.fetchAllSongs();
		//adding the songs in the model
		model.addAttribute("songlist", songlist);
		//sending createplaylist
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		//TODO: process POST request
		//adding playlist
		pserv.addPlaylist(playlist);
		//update song table
	List<Songs>	songlist=playlist.getSongs();
	for(Songs song : songlist) {
		song.getPlaylist().add(playlist);
		sserv.updateSong(song);
	}
		return "playlistsuccess";
	}
	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> plist=pserv.fetchPlaylists();
		//System.out.println(plist);
		model.addAttribute("plist" , plist);
		return "viewplaylists";
	}
	

}
