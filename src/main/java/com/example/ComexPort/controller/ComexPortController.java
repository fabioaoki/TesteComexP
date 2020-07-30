package com.example.ComexPort.controller;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComexPort.dto.UsuarioDto;
import com.example.ComexPort.responses.Response;
import com.example.ComexPort.service.ListaContatoService;
import com.example.ComexPort.service.UsuarioService;

@RestController
public class ComexPortController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ListaContatoService listaContatoService;

	@RequestMapping(value = "/comexPort", method = RequestMethod.POST)
	public ResponseEntity<Response<UsuarioDto>> cadastro(@Valid @RequestBody UsuarioDto usuarioDto,
			BindingResult result) throws Exception {
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return new ResponseEntity<Response<UsuarioDto>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			response.setData(usuarioService.cadastrar(usuarioDto));
			return new ResponseEntity<Response<UsuarioDto>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Response<UsuarioDto>>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/comexPort/{email}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> busca(@PathVariable(value = "email") String email) throws Exception {
		UsuarioDto usuarioDto = usuarioService.verificar(email);
		if (Objects.nonNull(usuarioDto)) {
			return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/comexPort/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UsuarioDto> alteraInformacao(@PathVariable(value = "id") long id,
			@RequestBody UsuarioDto usuarioDto) throws Exception {
		if (usuarioDto.getDataCriacao() == null && usuarioDto.getDataModificacao() == null) {
			UsuarioDto dto = usuarioService.verificarPorId(id);
			if (Objects.nonNull(dto)) {
				usuarioDto.setId(id);
				if (usuarioDto.getNome() != null) {
					return new ResponseEntity<UsuarioDto>(HttpStatus.BAD_REQUEST);
				}
				if (usuarioDto.getDataAniversario() == null) {
					usuarioDto.setDataAniversario(dto.getDataAniversario());
				}
				if (Strings.isEmpty(usuarioDto.getEndereco())) {
					usuarioDto.setEndereco(dto.getEndereco());
				}
				if (Strings.isEmpty(usuarioDto.getEmail()) || usuarioDto.getEmail() == null) {
					usuarioDto.setEmail(dto.getEmail());
				}
				usuarioDto.setDataCriacao(dto.getDataCriacao());
				usuarioDto.setId(dto.getId());
				usuarioDto.setNome(dto.getNome());
				usuarioService.atualiza(usuarioDto);
				return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
			}
		}
		return new ResponseEntity<UsuarioDto>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/comexPort/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UsuarioDto> deletaPessoa(@PathVariable(value = "id") long id) {
		try {
			usuarioService.delete(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/comexPortIdade/{email}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> idade(@PathVariable(value = "email") String email) throws Exception {
		UsuarioDto usuarioDto = usuarioService.verificar(email);
		if (Objects.nonNull(usuarioDto)) {
			Date atual = new Date();
			int i = atual.getYear() - usuarioDto.getDataAniversario().getYear();
			usuarioDto.setIdade(i);
			return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
