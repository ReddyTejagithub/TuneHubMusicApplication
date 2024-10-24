
package com.example.MusicApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MusicApplication.entities.Songs;
import com.example.MusicApplication.services.SongsService;

@Controller
public class SongsController {
	@Autowired
SongsService songserv;
@PostMapping("/addsongs")
public String addSongs(@ModelAttribute Songs song) {
	
	boolean songstatus=songserv.songexist(song.getName());
	if(songstatus==false) {
		songserv.addSongs(song);
		return "songsuccess";
	}else {
		return "songfail";
	}
}
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		List<Songs> songlist=songserv.fetchAllSongs();
		model.addAttribute("songlist", songlist);
		return "displaysongs";
		
	}@GetMapping("/viewsongs")
	public String viewCustomerSongs(Model model) {
		boolean primeCustomerStatus=true;
		if(primeCustomerStatus==true) {
			List<Songs> songlist = songserv.fetchAllSongs();
			model.addAttribute("songlist", songlist);
			return "displaysongs";
		}else {
			return "makepayment";
		}
	}
	
}


