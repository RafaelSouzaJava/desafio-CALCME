package com.rafael.calcme.desafio.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.calcme.desafio.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
