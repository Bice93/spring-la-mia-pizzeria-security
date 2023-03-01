package com.example.pizzeria.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pizzeria.model.User;
import com.example.pizzeria.repository.UserRepository;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return new DatabaseUserDetails(user.get());
		} else throw new UsernameNotFoundException("Utente non trovato!");
	}

}
