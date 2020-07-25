package com.example.ComexPort.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComexPort.dto.ListaContatoDto;
import com.example.ComexPort.responses.Response;
import com.example.ComexPort.service.ListaContatoService;

@RestController
public class ListaContatoController {

	@Autowired
	ListaContatoService listaContatoService;

	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	public ResponseEntity<Response<ListaContatoDto>> cadastro(@Valid @RequestBody ListaContatoDto listaContatoDto,
			BindingResult result) throws Exception {
		Response<ListaContatoDto> response = new Response<ListaContatoDto>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return new ResponseEntity<Response<ListaContatoDto>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			response.setData(listaContatoService.cadastrar(listaContatoDto));
			return new ResponseEntity<Response<ListaContatoDto>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Response<ListaContatoDto>>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
