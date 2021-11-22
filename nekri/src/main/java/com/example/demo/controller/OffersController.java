package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Offers;
import com.example.demo.repository.OffersRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class OffersController {

	@Autowired
	private OffersRepository offersRepository;

	// get all offers
	@GetMapping("/offers")
	public List<Offers> getAllOffers() {
		return offersRepository.findAll();
	}

	// get offer by id
	@GetMapping("/offers/{id}")
	public ResponseEntity<Offers> getOffersById(@PathVariable Long id) {
		System.out.println(id);
		Offers offers = offersRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(offers);
	}

	// add offer to database
	@PostMapping("/offers/add")
	public Offers postMethodName(@RequestBody Offers offer) {
		return offersRepository.save(offer);
	}

	// get the last offer added by user and return to the front
	@GetMapping("/offers/recentOne/{userId}")
	public Long getRecentOfferId(@PathVariable Long userId) {
		System.out.println(userId);
		return offersRepository.findOfferByUserId(userId);
	}

	// update offer :
	@PostMapping("/offers/{id}/update")
	public ResponseEntity<Offers> updateOldOffer(@PathVariable Long id, @RequestBody Offers offer) {

		System.out.println("offer =====================> " + offer.getOffer_id());
		Offers OldOffer = offersRepository.findById(id).orElseThrow();
		OldOffer.setAddress(offer.getAddress());
		OldOffer.setRoom_number(offer.getRoom_number());
		OldOffer.setArea(offer.getArea());
		OldOffer.setCity(offer.getCity());
		OldOffer.setContrat(offer.isContrat());
		OldOffer.setDuration(offer.getDuration());
		OldOffer.setDescription(offer.getDescription());
		OldOffer.setWater_electricity(offer.getWater_electricity());
		OldOffer.setWifi(offer.getWifi());
		OldOffer.setFloor(offer.getFloor());

		Offers updatedOldOffer = offersRepository.save(OldOffer);
		return ResponseEntity.ok(updatedOldOffer);
	}

	// decrement Rooms number
	@PostMapping("/offers/{id}/decrimentRoomsNumber")
	public void decrimentRoomsNumber(@PathVariable Long id) {

		System.out.println(id);
		Offers offer = offersRepository.findById(id).orElseThrow();
		offer.setRoom_number(offer.getRoom_number() - 1);
		offersRepository.save(offer);
	}

	// incriment Rooms number
	@PostMapping("/offers/{id}/incrimentRoomsNumber")
	public void incrimentRoomsNumber(@PathVariable Long id) {

		System.out.println(id);
		Offers offer = offersRepository.findById(id).orElseThrow();
		offer.setRoom_number(offer.getRoom_number() + 1);
		offersRepository.save(offer);
	}

	@PostMapping("/offers/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Offers offer = offersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offer not exist with id :" + id));
		offersRepository.delete(offer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


	@GetMapping("/offers/user/{userId}")
	public ResponseEntity<List<Offers>> getOffersByUserId(@PathVariable Long userId) {
		System.out.println(userId);
		List<Offers> offers = offersRepository.findOffersByUserId(userId);
		return ResponseEntity.ok(offers);
	}
}
