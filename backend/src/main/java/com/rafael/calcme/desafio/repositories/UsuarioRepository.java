package com.rafael.calcme.desafio.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.calcme.desafio.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	@Transactional(readOnly = true)
	Usuario findByLogin(String login);

}
