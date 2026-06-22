package com.backend.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.backend.entities.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRespDto {

	private Long id;
	private String title;
	private String isbn;
	private String publisher;
	private LocalDate publishYear;
	private int totalCopies;
	private Set<Long> authorIds;
}
