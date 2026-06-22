package com.backend.services;

import java.util.List;

import com.backend.dtos.BookReqDto;
import com.backend.dtos.BookRespDto;
import com.backend.entities.Book;

public interface BookService {

	public String addNewBook(BookReqDto dto);

	public List<BookRespDto> displayAllBooks();

	public BookRespDto displayBookById(Long bookId);

	public String updateBookById(Long bookId, BookReqDto dto);

	public String deleteBookById(Long bookId);

}
