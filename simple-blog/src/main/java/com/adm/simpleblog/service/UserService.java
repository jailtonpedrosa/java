package com.adm.simpleblog.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.simpleblog.model.User;
import com.adm.simpleblog.model.dto.UserDTO;
import com.adm.simpleblog.repository.UserRepository;
import com.adm.simpleblog.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(UUID id) {
		Optional<User> user = userRepository.findById(id);				
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());	
		updateData(newUser, user);		
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public void delete(UUID id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO);
	}
}
