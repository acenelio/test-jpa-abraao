package com.onetomany.onetomanyproblem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.onetomany.onetomanyproblem.entities.Education;
import com.onetomany.onetomanyproblem.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;

	private List<EducationDTO> educations = new ArrayList<>();

	public UserDTO() {

	}

	public UserDTO(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
	}

	public UserDTO(User entity, Set<Education> educations) {
		this(entity);
		educations.forEach(x -> this.educations.add(new EducationDTO(x)));
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public List<EducationDTO> getEducations() {
		return educations;
	}
}
