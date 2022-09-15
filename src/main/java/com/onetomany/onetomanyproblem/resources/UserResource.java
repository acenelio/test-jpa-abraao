package com.onetomany.onetomanyproblem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.onetomanyproblem.dto.PageDTO;
import com.onetomany.onetomanyproblem.dto.UserDTO;
import com.onetomany.onetomanyproblem.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<PageDTO<UserDTO>> findAll(Pageable pageable) {
		PageDTO<UserDTO> list = service.search2(pageable);
		return ResponseEntity.ok().body(list);
	}
}
