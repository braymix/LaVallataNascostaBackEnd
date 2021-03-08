package com.LaVallataNascostaBack.LaValle.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LaVallataNascostaBack.LaValle.model.Luogo;
import com.LaVallataNascostaBack.LaValle.repository.LuogoRepository;

@RestController
@RequestMapping("/api")
public class LuoghiController {
	@Autowired
	LuogoRepository luogoRepository;
	
	
	@GetMapping("/Luoghi")
	public ResponseEntity<List<Luogo>> getAllArticoli(@RequestParam(required = false) String title) {
		try {
			List<Luogo> tutorials = new ArrayList<Luogo>();
			
			luogoRepository.findAll().forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		tutorials.sort(Comparator.comparing(Luogo::getId));
			
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/Luoghi")
	public ResponseEntity<Luogo> createArticolo(@RequestBody Luogo luogo) {
		try {
			Luogo _articoli = luogoRepository.save(new Luogo(luogo.getTitolo(), luogo.getDescrizione(),luogo.getFoto1(),luogo.getFoto2(),luogo.getFoto3(),luogo.getCoordinate()));
			return new ResponseEntity<>(_articoli, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/Luoghi/{id}")
	public ResponseEntity<Luogo> updateArticolo(@PathVariable("id") String id, @RequestBody Luogo tutorial) {
		Optional<Luogo> tutorialData = luogoRepository.findById(id);

		if (tutorialData.isPresent()) {
			Luogo _tutorial = tutorialData.get();
			_tutorial.setCoordinate(tutorial.getCoordinate());
			_tutorial.setDescrizione(tutorial.getDescrizione());
			_tutorial.setFoto1(tutorial.getFoto1());
			_tutorial.setFoto2(tutorial.getFoto2());
			_tutorial.setFoto3(tutorial.getFoto3());
			_tutorial.setId(tutorial.getId());
			_tutorial.setTitolo(tutorial.getTitolo());
			return new ResponseEntity<>(luogoRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Articolo/{id}")
	public ResponseEntity<Luogo> deleteArticoli(@PathVariable("id") String id) {
		try {
			luogoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
