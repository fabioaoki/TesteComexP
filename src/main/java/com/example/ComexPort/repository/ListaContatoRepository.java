package com.example.ComexPort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComexPort.entity.ListaContato;

public interface ListaContatoRepository extends JpaRepository<ListaContato, Long> {
	
	ListaContato findById(long id);

}
