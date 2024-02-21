package com.adm.simpleblog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.simpleblog.model.User;
import com.adm.simpleblog.model.dto.UserDTO;
import com.adm.simpleblog.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x.getId(), x.getName(), x.getEmail())).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(listDTO);
	}
}
