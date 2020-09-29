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
	//TODO: INSTANCIAR ADRESS AQUI
	//Version prueba: adress inventada
	@PostMapping("/createUsers")
	public void createUsers(@RequestBody User entity) {
		Adress dir = new Adress();
		//dir.setCity(entity.getAdress().getCity());
		/*dir.setCity("Madrid");
		dir.setCountry("Spain");
		dir.setId(1);
		dir.setState("spaMAL");
		dir.setStreet("falsa");
		dir.setZip("zip2");*/
		
		String city, country,state, street, zip;
		Integer id;
		id = entity.getAdress().getId();
		if(id == null)
			id = 1;
		
		city = entity.getAdress().getCity();
		if(city == null)
			city = "FAKE";
		
		country = entity.getAdress().getCountry();
		if(country == null)
			country = "FAKE";
		
		state = entity.getAdress().getState();
		if(state == null)
			state = "FAKE";
		
		street = entity.getAdress().getStreet();
		if(street == null)
			street = "FAKE";
		
		zip = entity.getAdress().getZip();
		if(zip == null)
			zip = "FAKE";
		
		/*dir.setCity(entity.getAdress().getCity());
		dir.setCountry(entity.getAdress().getCountry());
		dir.setId(entity.getAdress().getId());
		dir.setState(entity.getAdress().getState());
		dir.setStreet(entity.getAdress().getStreet());
		dir.setZip(entity.getAdress().getZip());*/
		
		dir.setCity(city);
		dir.setCountry(country);
		dir.setId(id);
		dir.setState(state);
		dir.setStreet(street);
		dir.setZip(zip);
		
		/*Integer p = (Integer)((Map) entity).get("id");
		dir.setId( (Integer)((Map) entity).get("id"));
		dir.setCountry( (String)((Map) entity).get("country"));
		dir.setCity( (String)((Map) entity).get("city"));
		dir.setState( (String)((Map) entity).get("state"));
		dir.setStreet( (String)((Map) entity).get("street"));
		dir.setZip( (String)((Map) entity).get("zip"));*/
		
		entity.setAdress(dir);
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