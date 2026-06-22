package com.backend.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name="books")
@AttributeOverride(name="id",column=@Column(name="book_id"))
public class Book extends BaseClass{

	@Column(name="title" ,length=150)
	private String title;
	@Column(name="isbn" ,length=50,nullable=false)
	private String isbn;
	@Column(name="publisher" ,length=150)
	private String publisher;
	@Column(name="publish_year")
	private LocalDate publishYear;
	@Column(name="total_copies")
	private int totalCopies;
	@OneToMany(mappedBy="book")
	private List<Issue> issue = new ArrayList<>();
	@OneToMany(mappedBy="book")
	private List<Copy> copy = new ArrayList<>();
	@ManyToMany()
	@JoinTable(name="book_author",joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns =  @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
}
