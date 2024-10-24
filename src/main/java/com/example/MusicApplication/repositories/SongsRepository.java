package com.example.MusicApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MusicApplication.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer>{
	
public Songs findByName(String name);
}
