package com.example.MusicApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MusicApplication.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
public Users findByEmail(String email);


}
