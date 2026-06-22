package com.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dtos.AuthorReq;
import com.backend.dtos.AuthorResp;
import com.backend.entities.Author;
import com.backend.exception.ResourceNotFoundException;
import com.backend.repositories.AuthorRepo;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
	
	private final AuthorRepo authRepo;
	private final ModelMapper mapper;
	
	@Override
	public String addAuthor(AuthorReq auth) {
		
		Author author = mapper.map(auth,Author.class);
		authRepo.save(author);
		return "Author Added Successfully";
	}

	@Override
	public List<AuthorResp> getAllAuthor() throws ResourceNotFoundException {
		
		List<Author> authors = authRepo.findAll();
		List<AuthorResp> auth = new ArrayList<>();
		if(authors.isEmpty()) {
			throw new ResourceNotFoundException("no author listed");
		}
		else {
			for(Author a:authors) {
				AuthorResp res = mapper.map(a,AuthorResp.class);
				auth.add(res);
			}
		}
		return auth;
	}


	@Override
	public AuthorResp getAuthor(Long id) throws ResourceNotFoundException {

	    Author author = authRepo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("No such Author exists"));
	    AuthorResp auth = mapper.map(author,AuthorResp.class);
	    return auth;
	}

	@Override
	public String updateAuthorById(Long authorId,String name) throws ResourceNotFoundException {
		
		Author author = authRepo.findById(authorId).orElseThrow(()->new ResourceNotFoundException("no such author"));
		
		author.setName(name);
		
		authRepo.save(author);
		
		return "Updation successfull";
	}

	@Override
	public String deleteAuthorById(Long authorId) throws ResourceNotFoundException {
		
		Author author = authRepo.findById(authorId).orElseThrow(()->new ResourceNotFoundException("no author exist"));
		authRepo.delete(author);
		return "deleted successfully";
	}
	
	
	
	
}
