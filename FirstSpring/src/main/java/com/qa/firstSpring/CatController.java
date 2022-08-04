package com.qa.firstSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.firstSpring.models.Cat;
import com.qa.firstSpring.service.CatService;

@RestController
@RequestMapping("/home")
public class CatController {
	
	CatService service;
	
	@Autowired
	public CatController(CatService service) {
		this.service = service;
	}

	@GetMapping()
	public String showHOne() {
		return "<h1>Cats!</h1>"
				+ "<br/>"
				+ "<p> Home </p>";
	}
	
	@GetMapping("/getCats")
	public ResponseEntity <List<Cat>> getCats() {
		List<Cat> catData = service.readAllCats();
		return new ResponseEntity<List<Cat>>(catData, HttpStatus.OK);
	}
	
	@PostMapping("/createCat")
	public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
		Cat createCat = service.createCat(cat);
		return new ResponseEntity<Cat>(createCat, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCat/{id}")
	public ResponseEntity<Cat> updateCat(@RequestBody Cat cat, Long id) {
		Cat updateCat = service.updateCat(cat, id);
		return new ResponseEntity<Cat>(updateCat, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCat/{id}")
	public ResponseEntity<Boolean> deleteCat(Long id) {
		Boolean deletedCat = service.deleteCat(id);
		return new ResponseEntity<Boolean>(deletedCat, HttpStatus.NO_CONTENT);
	}
}

