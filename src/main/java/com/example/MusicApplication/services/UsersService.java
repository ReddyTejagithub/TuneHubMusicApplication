package com.example.MusicApplication.services;



import com.example.MusicApplication.entities.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean emailExist(String email );
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public Users getUser(String email);
	
}