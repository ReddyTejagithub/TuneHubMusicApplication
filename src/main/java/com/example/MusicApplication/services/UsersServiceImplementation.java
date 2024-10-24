package com.example.MusicApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicApplication.entities.Users;
import com.example.MusicApplication.repositories.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService{
	@Autowired
UsersRepository urepo;
	@Override
	public String addUser(Users user) {
		urepo.save(user);
		return "User is created and Saved" ;
	}
	@Override
	public boolean emailExist(String email) {
if(urepo.findByEmail(email)==null) {
	return false;
}else {
	return true;
}
		
	}
	@Override
	public boolean validateUser(String email, String password) {
	Users user=	urepo.findByEmail(email);
	String dbPassword=user.getPassword();
	if(dbPassword .equals(password)) {
		return true;
	}
		return false;
	}
	@Override
	public String getRole(String email) {
		Users user=urepo.findByEmail(email);
		String role=user.getRole();
		return role;
	}
	@Override
	public Users getUser(String email) {
		return urepo.findByEmail(email);
		
	}

}
