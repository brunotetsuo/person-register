package com.exemplo.personregister.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.personregister.entities.Person;
import com.exemplo.personregister.repositories.PersonRepository;

@Service  // Indica que é uma classe de serviço.
public class PersonService {
	
	@Autowired 	// Injeção automática de dependência do spring.
	private PersonRepository repository;
	
	// POST
	public Person insert(Person obj) {
		return repository.save(obj);
	}
	
	// GET
	public List<Person> findAll() {
		return repository.findAll();
	}

}
