package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	// get all users
	@GetMapping("/users")
	public List<Users> getAllEmployees() {
		return usersRepository.findAll();
	}

	//et user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getDemandsById(@PathVariable Long id) {
		Users demands = usersRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(demands);
	}

	//update the user by his id
	@PostMapping("/users/update/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+user.toString());
		Users oldUser = usersRepository.findById(id)
				.orElseThrow();		
		oldUser.setFull_name(user.getFull_name());
		oldUser.setUser_name(user.getUser_name());
		oldUser.setProfil_image(user.getProfil_image());
		oldUser.setGender(user.getGender());
		oldUser.setPhone(user.getPhone());
		oldUser.setEmail(user.getEmail());	
		oldUser.setUniversity(user.getUniversity());
		oldUser.setDegre(user.getDegre());
		oldUser.setPassword(user.getPassword());
		
		oldUser.setConfirmed_email(user.isConfirmed_email());
		
		Users updatedoldUser = usersRepository.save(oldUser);
		return ResponseEntity.ok(updatedoldUser);
	}
	

	@PostMapping("/signup")
	public String signUp(@RequestBody Users user) {
		System.out.println("password" + user.toString());

		if (!user.getConfirmPassword().equals(user.getPassword()))
			return "paswwords does not matched";

		Optional<Users> usernameExit = usersRepository.getUserByUsername(user.getUser_name());
		if (usernameExit.isPresent())
			return "username exist";

		usersRepository.save(user);
		// rederict /login
		return "ok";
	}

	@PostMapping("/login")
	public Long login(@RequestBody Users user) {

		Optional<Users> userLogin = usersRepository.getUserByUsernameAndPassword(user.getUser_name(),user.getPassword());
		if (userLogin.isPresent()) {
			// rederect to home
			return usersRepository.getUserById(user.getUser_name());
		}
		return 0l;
	}

}
