package com.backend.entities;

import java.time.LocalDate;

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
@ToString(callSuper=true)
@Entity
@Table(name="issue")
@AttributeOverride(name="id",column=@Column(name="issue_id"))
public class Issue extends BaseClass{

	@Column(name="issue_date")
	LocalDate issueDate;
	@Column(name="return_date")
	LocalDate returnDate;
	@Enumerated(EnumType.STRING)
	IssueStatus status=IssueStatus.valueOf("RETURNED");
	@ManyToOne
	@JoinColumn(name="member_id",nullable=false)
	private Member member;
	@ManyToOne
	@JoinColumn(name="copy_id" ,nullable=false)
	private Book book;
}
