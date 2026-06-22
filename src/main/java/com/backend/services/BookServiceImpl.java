package com.backend.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.controller.AuthorController;
import com.backend.dtos.BookReqDto;
import com.backend.dtos.BookRespDto;
import com.backend.entities.Author;
import com.backend.entities.Book;
import com.backend.repositories.AuthorRepo;
import com.backend.repositories.BookRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService{

    private final AuthorController authorController;

	private final AuthorRepo authRepo;
	private final BookRepo bookRepo;
	private final ModelMapper mapper;

   
	@Override
	public String addNewBook(BookReqDto dto) {
		
		Set<Author> authors =
		        new HashSet<>(authRepo.findAllById(dto.getAuthorIds()));
		
		Book book = new Book();
		book = mapper.map(dto, Book.class);
		book.setAuthors(authors);
		bookRepo.save(book);
		
		return "new Book added successfully";
	}
	@Override
	public List<BookRespDto> displayAllBooks() {
		
		List<Book> books = bookRepo.findAll();
		List<BookRespDto> bookres = new ArrayList<>();
		
		for(Book b:books) {
			BookRespDto r = mapper.map(b,BookRespDto.class);
			Set<Long> AuthorIds = new HashSet<>();
			for(Author author : b.getAuthors()) {
				AuthorIds.add(author.getId());
			}
			r.setAuthorIds(AuthorIds);
			bookres.add(r);
		}
		return bookres;
	}
	@Override
	public BookRespDto displayBookById(Long bookId) {
		
		  Book book = bookRepo.findById(bookId).orElseThrow();
		  BookRespDto b = mapper.map(book, BookRespDto.class);
		  Set<Long> authorIds = new HashSet<>();

		    for(Author author : book.getAuthors()) {
		        authorIds.add(author.getId());
		    }

		    b.setAuthorIds(authorIds);
		    return b;
	}
	@Override
	public String updateBookById(Long bookId, BookReqDto dto) {
		
		Book book = bookRepo.findById(bookId).orElseThrow();
		
		book = mapper.map(dto,Book.class);
		
		return "updation successfull";
	}
	@Override
	public String deleteBookById(Long bookId) {
		
		Book book = bookRepo.findById(bookId).orElseThrow();
		bookRepo.deleteById(bookId);
		return "Deleted successfully";
	}
	

}
