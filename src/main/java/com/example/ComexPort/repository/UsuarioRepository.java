package com.example.ComexPort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComexPort.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);
}
