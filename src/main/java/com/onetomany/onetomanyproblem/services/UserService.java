package com.onetomany.onetomanyproblem.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetomany.onetomanyproblem.dto.EducationDTO;
import com.onetomany.onetomanyproblem.dto.PageDTO;
import com.onetomany.onetomanyproblem.dto.UserDTO;
import com.onetomany.onetomanyproblem.entities.Education;
import com.onetomany.onetomanyproblem.entities.User;
import com.onetomany.onetomanyproblem.repositories.EducationRepository;
import com.onetomany.onetomanyproblem.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EducationRepository educationRepository;
	
	// Esta abordagem causa idas e vindas ao banco. Nao deve ser utilizada.
	// Mesmo chamando o metodo findFullUserProfile, o JPA / Spring Data JPA fica voltando ao 
	// banco depois para tentar buscar educations dos usuarios que nao possuem educations
	@Transactional(readOnly = true)
	public Page<UserDTO> search1(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		repository.findFullUserProfile(page.getContent());
		return page.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public PageDTO<UserDTO> search2(Pageable pageable) {

		Page<User> page = repository.findAll(pageable);

		// Buscando no banco de dados as educations dos usuarios encontrados
		List<Education> educations = educationRepository.searchEducations(page.getContent());
		
		// Salvando uma lista dos resultado como DTO (ainda sem educations)
		List<UserDTO> list = page.map(x -> new UserDTO(x)).toList();
		
		// Salvando um map dos objetos para ter acesso performatico a eles
		Map<Long, UserDTO> map = new HashMap<>();
		for (UserDTO dto : list) {
			map.put(dto.getId(), dto);
		}

		// Associando as educations encontradas aos seus respectivos users
		for (Education educ : educations) {
			UserDTO userDto = map.get(educ.getUser().getId());
			userDto.getEducations().add(new EducationDTO(educ));
		}

		// Gerando o objeto final de resposta
		PageDTO<UserDTO> result = new PageDTO<UserDTO>(list, page);

		return result;
	}
}
