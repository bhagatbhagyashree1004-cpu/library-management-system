package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

}
