package com.exemplo.personregister.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.personregister.entities.Person;

@Repository  // Indica que é um repositório, uma abstração de acesso e armazenamento de dados.
public interface PersonRepository extends JpaRepository<Person, String> {
	
	Optional<Person> findByName(String name);

}
