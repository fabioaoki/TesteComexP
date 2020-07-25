package com.example.ComexPort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ComexPort.dto.ListaContatoDto;
import com.example.ComexPort.entity.ListaContato;
import com.example.ComexPort.repository.ListaContatoRepository;
import com.example.ComexPort.repository.UsuarioRepository;

@Service
public class ListaContatoService {

	@Autowired
	ListaContatoRepository listaContatoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public ListaContatoDto cadastrar(ListaContatoDto listaContatoDto) throws Exception {
		try {
			usuarioRepository.findById(listaContatoDto.getIdUsuario().getId());
		} catch (Exception e) {
			throw new Exception("usuario nao encontrado");
		}
		ListaContato listaContato = ListaContato.builder().tipo(listaContatoDto.getTipo())
				.detalhe(listaContatoDto.getDetalhe()).idUsuario(listaContatoDto.getIdUsuario().getId()).build();
		listaContatoRepository.save(listaContato);
		return listaContatoDto;
	}
}
