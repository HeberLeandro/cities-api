package com.github.heberleandro.citesapi.countries;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryResource {
	
	@Autowired
	private CountryRepository repository;

	@GetMapping
	public Page<Country> countries(Pageable page){
		return repository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable Long id) {
		Optional<Country> optional = repository.findById(id);
		return (optional.isPresent()) ? ResponseEntity.ok().body(optional.get()) : ResponseEntity.notFound().build();
	}
}
