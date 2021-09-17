package com.rafael.calcme.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rafael.calcme.desafio.model.Usuario;
import com.rafael.calcme.desafio.repositories.UsuarioRepository;
import com.rafael.calcme.desafio.secutity.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByLogin(login);
		if(user == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(user.getId(), user.getLogin(), user.getSenha());
	}

}
