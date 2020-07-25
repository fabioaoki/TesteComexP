package com.example.ComexPort.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ComexPort.dto.UsuarioDto;
import com.example.ComexPort.entity.Usuario;
import com.example.ComexPort.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioDto cadastrar(UsuarioDto usuarioDto, Date date) {
		usuarioDto.prePersist(usuarioDto);
		Usuario usuario = Usuario.builder().nome(usuarioDto.getNome()).email(usuarioDto.getEmail())
				.dataAniversario(date).dataCriacao(usuarioDto.getDataCriacao()).build();
		usuarioRepository.save(usuario);
		return usuarioDto;
	}

	public UsuarioDto verificar(long id) {
		try {
			Usuario usuario = usuarioRepository.findById(id);
			return UsuarioDto.builder().id(usuario.getId()).nome(usuario.getNome())
					.dataAniversario(usuario.getDataAniversario().toString())
					.endereco(usuario.getEndereco()).dataCriacao(usuario.getDataCriacao())
					.dataModificacao(usuario.getDataModificacao()).build();
		} catch (Exception e) {
			UsuarioDto dto = null;
			return dto;
		}
	}
}

