package com.example.ComexPort.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;

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

	@RequestMapping(value="/comexPort",method = RequestMethod.POST)
	public ResponseEntity<Response<UsuarioDto>> cadastro(@Valid @RequestBody UsuarioDto usuarioDto, 
			BindingResult result) throws Exception{
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return new ResponseEntity<Response<UsuarioDto>>(response,HttpStatus.BAD_REQUEST);
		}
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(usuarioDto.getDataAniversario());
		response.setData(usuarioService.cadastrar(usuarioDto, date));
		return new ResponseEntity<Response<UsuarioDto>>(response,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/comexPort/{id}",method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> weather(@PathVariable(value= "id") long id) {
		UsuarioDto usuarioDto = usuarioService.verificar(id);
		if(Objects.nonNull(usuarioDto)) {
			return new ResponseEntity<UsuarioDto>(usuarioDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
