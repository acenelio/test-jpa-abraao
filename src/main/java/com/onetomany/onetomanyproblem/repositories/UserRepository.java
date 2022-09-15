package com.onetomany.onetomanyproblem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onetomany.onetomanyproblem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM User obj "
			+ "JOIN FETCH obj.educations "
			+ "WHERE obj IN :users ")	
	List<User> findFullUserProfile(List<User> users);	
}
