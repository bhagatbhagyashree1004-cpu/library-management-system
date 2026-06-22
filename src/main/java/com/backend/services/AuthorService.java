package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.dtos.AuthorReq;
import com.backend.dtos.AuthorResp;
import com.backend.entities.Author;
import com.backend.exception.ResourceNotFoundException;
import com.backend.repositories.AuthorRepo;

import lombok.RequiredArgsConstructor;

public interface AuthorService {

	public String addAuthor(AuthorReq auth) ;

	public List<AuthorResp> getAllAuthor() throws ResourceNotFoundException;

	public AuthorResp getAuthor(Long id) throws ResourceNotFoundException;

	public String updateAuthorById(Long authorId,String name) throws ResourceNotFoundException;

	public String deleteAuthorById(Long authorId) throws ResourceNotFoundException;

}
