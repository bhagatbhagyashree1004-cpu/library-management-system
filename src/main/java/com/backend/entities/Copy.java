package com.backend.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="copy")
@AttributeOverride(name="id",column=@Column(name="copy_id"))
public class Copy extends BaseClass{

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.valueOf("AVAILABLE");
	@ManyToOne
	@JoinColumn(name="book_id",nullable=false)
	private Book book;
}
