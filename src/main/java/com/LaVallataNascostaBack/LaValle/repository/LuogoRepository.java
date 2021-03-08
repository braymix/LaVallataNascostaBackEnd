package com.LaVallataNascostaBack.LaValle.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.LaVallataNascostaBack.LaValle.model.Luogo;

public interface LuogoRepository extends MongoRepository<Luogo, String> {

	List<Luogo> findByTitolo(String titolo);
	
	List<Luogo> findById(int id);
}
