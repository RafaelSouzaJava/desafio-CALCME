package com.rafael.calcme.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.calcme.desafio.model.Usuario;
import com.rafael.calcme.desafio.model.dto.UsuarioNewDTO;
import com.rafael.calcme.desafio.repositories.UsuarioRepository;
import com.rafael.calcme.desafio.service.exceptions.DataIntegrityException;
import com.rafael.calcme.desafio.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Usuario buscar(String id) {
		Optional<Usuario> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"User Não Encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = userRepository.save(obj);		
		return obj;
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario user = new Usuario(null, objDto.getLogin(), pe.encode(objDto.getSenha()));
		return user;
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = buscar(obj.getId());		
		updateProduto(newObj, obj);
		return userRepository.save(newObj);
	}

	private void updateProduto(Usuario newObj, Usuario obj) {
		if (obj.getLogin() != null) {
			newObj.setLogin(obj.getLogin());
		}
		if (obj.getSenha() != null) {
			newObj.setSenha(pe.encode(obj.getSenha()));
		}
	}

	public void delete(String id) {
		buscar(id);
		try {
			userRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir o Usuario");
		}
	}

	public List<Usuario> buscarTodos() {
		return userRepository.findAll();
	}

}
