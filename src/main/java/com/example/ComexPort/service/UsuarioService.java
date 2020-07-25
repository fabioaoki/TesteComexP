package com.example.ComexPort.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ComexPort.dto.UsuarioDto;
import com.example.ComexPort.entity.Usuario;
import com.example.ComexPort.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDto cadastrar(UsuarioDto usuarioDto) throws Exception {
		verificaEmail(usuarioDto);
		usuarioDto.prePersist(usuarioDto);
		Usuario usuario = Usuario.builder().nome(usuarioDto.getNome()).email(usuarioDto.getEmail())
				.dataAniversario(usuarioDto.getDataAniversario()).dataCriacao(usuarioDto.getDataCriacao()).build();
		usuarioRepository.save(usuario);
		return usuarioDto;
	}

	private void verificaEmail(UsuarioDto usuarioDto) throws Exception {
		ArrayList<Usuario> email = usuarioRepository.findByEmail(usuarioDto.getEmail());

		for (int i = 0; i < email.size(); i++) {
			String a = email.get(i).getEmail();
			if (a.equals(usuarioDto.getEmail()) && usuarioDto.getDataCriacao() == null) {
				throw new Exception("email ja cadastrado");
			}
		}
	}

	public UsuarioDto verificar(String email) {
		try {
			ArrayList<Usuario> usuario = usuarioRepository.findByEmail(email);
			for (int i = 0; i < usuario.size();) {
				Usuario dto = usuario.get(i);
				return UsuarioDto.builder().id(dto.getId()).nome(dto.getNome())
						.dataAniversario(dto.getDataAniversario()).endereco(dto.getEndereco())
						.dataCriacao(dto.getDataCriacao()).dataModificacao(dto.getDataModificacao()).build();
			}
		} catch (Exception e) {
			UsuarioDto dto = null;
			return dto;
		}
		return null;
	}

	public UsuarioDto atualiza(UsuarioDto usuarioDto) throws Exception {
		verificaEmail(usuarioDto);
		usuarioDto.prePersist(usuarioDto);
		Usuario usuario = Usuario.builder().id(usuarioDto.getId()).nome(usuarioDto.getNome()).email(usuarioDto.getEmail())
				.dataAniversario(usuarioDto.getDataAniversario()).dataCriacao(usuarioDto.getDataCriacao()).endereco(usuarioDto.getEndereco())
				.dataModificacao(usuarioDto.getDataModificacao()).build();
		usuarioRepository.save(usuario);
		return usuarioDto;
	}

	public void delete(long id) {
		usuarioRepository.deleteById(id);
	}

	public UsuarioDto verificarPorId(long id) {
		try {
			Usuario usuario = usuarioRepository.findById(id);
			return UsuarioDto.builder().id(usuario.getId()).nome(usuario.getNome()).email(usuario.getEmail())
					.dataAniversario(usuario.getDataAniversario()).endereco(usuario.getEndereco())
					.dataCriacao(usuario.getDataCriacao()).dataModificacao(usuario.getDataModificacao()).build();

		} catch (Exception e) {
			UsuarioDto dto = null;
			return dto;
		}
	}
}
