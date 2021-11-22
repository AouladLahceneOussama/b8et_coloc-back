package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demands;
import com.example.demo.repository.DemandsRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")

public class DemandsController {

	@Autowired
	private DemandsRepository demandsRepository;

	// get all demandd
	@GetMapping("/demands")
	public List<Demands> getAllDemands() {
		return demandsRepository.findAll();
	}

	// get demand by id
	@GetMapping("/demands/{id}")
	public ResponseEntity<Demands> getDemandsById(@PathVariable Long id) {
		Demands demands = demandsRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(demands);
	}

	// Post add demand
	@PostMapping("/demands/add")
	public Demands postMethod(@RequestBody Demands demand) {
		// System.out.println("offer object" + offer);
		return demandsRepository.save(demand);
	}

	// add update statut !!!!!!!!!!!!!!
	/**** Get Demande where Statut =0 ****/

	@GetMapping("/demand/status/0")
	public Collection<Demands> getAllDem() {
		return demandsRepository.findDemand();
	}

	@PostMapping("/demands/update/{id}")
	public void updateStatut(@PathVariable Long id, @RequestBody String Statut) {
		System.out.println(Statut);
		Demands demand = demandsRepository.findById(id).orElseThrow();
		demand.setStatut(Statut);
		demandsRepository.save(demand);
	}

}
