package com.rafael.calcme.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.calcme.desafio.model.Cliente;
import com.rafael.calcme.desafio.repositories.ClienteRepository;
import com.rafael.calcme.desafio.service.exceptions.DataIntegrityException;
import com.rafael.calcme.desafio.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;
	
		
	public Cliente buscar(String id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente Não Encontrado! Id: " +id + ", Tipo: "+Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);		
		emailService.emailConfirmationHtml(obj);
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = buscar(obj.getId());
		updateProduto(newObj, obj);
		return clienteRepository.save(newObj);
	}
	
	private void updateProduto(Cliente newObj, Cliente obj) {
		if(obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if(obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());
		}
		if(obj.getTelefone() != null) {
			newObj.setTelefone(obj.getTelefone());
		}
		
	}

	public void delete(String id) {
		buscar(id);
		try {
			clienteRepository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir o Cliente");
		}
	}
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	
}
