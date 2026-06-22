package com.backend.controller;

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

import com.backend.dtos.AuthorReq;
import com.backend.exception.ResourceNotFoundException;
import com.backend.services.AuthorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<?> addAuthor(@RequestBody AuthorReq auth){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(auth));
	}
	
	@GetMapping("/listAuthor")
	public ResponseEntity<?> getAllAuthor() throws ResourceNotFoundException{
		
		return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthor());
	}
	
	@PostMapping("/{authorId}")
	public ResponseEntity<?> getAuthor(@PathVariable Long authorId) throws ResourceNotFoundException{
		
		return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthor(authorId));
	}
	
	@PutMapping("/{authorId}")
	public ResponseEntity<?> updateAuthor(@PathVariable Long authorId,@RequestParam String name) throws ResourceNotFoundException{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorService.updateAuthorById(authorId,name));
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId) throws ResourceNotFoundException{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorService.deleteAuthorById(authorId));
	}
} 
