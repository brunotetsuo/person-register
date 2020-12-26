package com.exemplo.personregister.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

}
