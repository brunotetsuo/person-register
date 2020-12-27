package com.exemplo.personregister.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.personregister.entities.Person;
import com.exemplo.personregister.services.PersonService;

@RestController  // Indica que vai ser uma controladora REST.
@RequestMapping(value = "/persons")  // Define a url que quando for requisitada chamara o metodo.
public class PersonResource {
	
	@Autowired  // Injeção automática de dependência do spring.
	private PersonService service;
	
	@PostMapping  // Atalho para simplificar o mapeamento dos métodos HTTP.
	public ResponseEntity<Person> insert(@Valid @RequestBody Person obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<Person> findByName(@PathVariable String name) {
		Person obj = service.findByName(name);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{name}")
	public ResponseEntity<Void> delete(@PathVariable String name) {
		service.delete(name);
		return ResponseEntity.noContent().build();
	}

}
