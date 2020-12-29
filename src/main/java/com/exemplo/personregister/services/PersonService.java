package com.exemplo.personregister.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.personregister.entities.Person;
import com.exemplo.personregister.repositories.PersonRepository;
import com.exemplo.personregister.services.exceptions.ResourceNotFoundException;

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
	
	// GET
	public Person findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	// PUT
	public Person update(Long id, Person obj) {
		Person entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Person entity, Person obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setBirthDate(obj.getBirthDate());
	}

}
