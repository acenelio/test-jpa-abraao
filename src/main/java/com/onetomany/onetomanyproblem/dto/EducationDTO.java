package com.onetomany.onetomanyproblem.dto;

import java.io.Serializable;

import com.onetomany.onetomanyproblem.entities.Education;

public class EducationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String schoolName;
	private String courseName;

	public EducationDTO() {

	}

	public EducationDTO(Long id, String schoolName, String courseName) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.courseName = courseName;
	}

	public EducationDTO(Education entity) {
		super();
		this.id = entity.getId();
		this.schoolName = entity.getSchoolName();
		this.courseName = entity.getCourseName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
