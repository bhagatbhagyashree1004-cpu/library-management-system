package com.backend.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.entities.Author;
import com.backend.entities.Copy;
import com.backend.entities.Issue;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReqDto {
	
	@NotBlank(message="required field")
	private String title;
	@NotNull(message="unique")
	private String isbn;
	@NotBlank(message="publisher")
	private String publisher;
	private LocalDate publishYear;
	@Positive
	private int totalCopies;
	private Set<Long> authorIds = new HashSet<>();
}
