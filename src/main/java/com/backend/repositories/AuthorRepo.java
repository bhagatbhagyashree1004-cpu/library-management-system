package com.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entities.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long>{

	public Optional<Author> findById(Long id);
}
