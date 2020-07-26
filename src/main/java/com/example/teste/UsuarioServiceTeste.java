package com.example.teste;

import java.util.Date;

import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ComexPort.dto.UsuarioDto;
import com.example.ComexPort.repository.UsuarioRepository;
import com.example.ComexPort.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTeste {
	
	@InjectMocks
	UsuarioService usuarioService;

	@Mock
	UsuarioRepository usuarioRepository;
	
	@Test
	public void testeCadastrar(UsuarioDto usuarioDto) throws Exception {
		Date atual = new Date();
		 
		usuarioDto.setNome("fabio aoki");
		usuarioDto.setEmail("fabio@aoki.com");
		usuarioDto.setEndereco("rua aoki 123");
		usuarioDto.setDataAniversario(new Date(1993, 9, 11));
		
		UsuarioDto dto;
		dto = usuarioService.cadastrar(usuarioDto);
		Assert.assertNotNull(dto);
	}

}
