package com.onetomany.onetomanyproblem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onetomany.onetomanyproblem.entities.Education;
import com.onetomany.onetomanyproblem.entities.User;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

	@Query("SELECT obj FROM Education obj JOIN FETCH obj.user WHERE obj.user IN :users")
	List<Education> searchEducations(List<User> users);	
}
