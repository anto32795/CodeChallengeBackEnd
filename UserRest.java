package com.codechallenge2.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge2.dao.*;
import com.codechallenge2.models.*;

/*
 * 	Metodos a implementar: 
 * 	
 * 	/getusers 					GET
 * 	/createUsers 				POST
 * 	/getUsersById/{userId} 		GET
 * 	/updateUsersById/{userId} 	PUT
 * 	/deleteUsersById/{userId}	DELETE
 * 
 * */
@RestController
@RequestMapping(
		  value = "user", 
		  produces = "application/json", 
		  method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST})

public class UserRest {
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	//@RequestBody para convertir fichero a clase user"
	@PostMapping("/createUsers")
	public void createUsers(@RequestBody User entity) {
		userDao.save(entity);
	}
	
	// if empty-> return optional (lista vacia); else-> return lista
	@GetMapping("/getUsersById/{userId}")
	public Optional<User> getUsers(@PathVariable("userId") Integer userId){
		return userDao.findById(userId);
	}
	
	/* Borra la entidad con el id del primer parametro y guarda la entidad nueva */
	@PutMapping("/updateUsersById/{userId}")
	public void updateUsersById(@PathVariable Integer userId, @RequestBody User entity) {
		userDao.deleteById(userId);
		userDao.save(entity);
	}
	
	@DeleteMapping("/deleteUsersById/{userId}")
	public void deleteUsersById(@PathVariable("userId") Integer userId) {
		userDao.deleteById(userId);
	}
	
	
	
}
