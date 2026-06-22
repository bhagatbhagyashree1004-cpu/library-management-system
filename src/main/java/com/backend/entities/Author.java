package com.backend.entities;


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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
@Entity
@Table(name="authors")
@AttributeOverride(name="id",column=@Column(name="author_id"))
public class Author extends BaseClass{

	@Column(name="name",length=180,nullable=false)
	private String name;
	@Column(name="email",length=180,unique=true)
	private String email;
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
}
