package com.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.BookReqDto;
import com.backend.services.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody BookReqDto dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addNewBook(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> displayAllBooks(){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.displayAllBooks());
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> displayBookById(@PathVariable Long bookId){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.displayBookById(bookId));
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<?> updateBook(@PathVariable Long bookId,@RequestBody BookReqDto dto){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBookById(bookId,dto));
		
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> deleteBookById(@PathVariable Long bookId){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBookById(bookId));
	}
}
