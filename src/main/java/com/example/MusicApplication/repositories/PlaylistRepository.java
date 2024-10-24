package com.example.MusicApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MusicApplication.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
