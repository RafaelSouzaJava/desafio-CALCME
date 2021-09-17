package com.rafael.calcme.desafio.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id	
	private String id;	
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER	)
	private String telefone;	
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	
	public Cliente() {	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append("Nome ");
		builder.append(nome);
		builder.append("\nTelefone ");
		builder.append(telefone);
		builder.append("\nEmail ");
		builder.append(email);		
		return builder.toString();
	}	

}
