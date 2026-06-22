package com.backend.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name="members")
@AttributeOverride(name="id",column=@Column(name="member_id"))
public class Member extends BaseClass{

	@Column(name="name",length=150)
	private String name;
	@Column(name="email",length=150,unique=true)
	private String email;
	@Column(name="phone",length=20)
	private String phone;
	@Column(name="address",length=190)
	private String address;
	@OneToMany(mappedBy="member")
	private List<Issue> issue = new ArrayList<>();
}
