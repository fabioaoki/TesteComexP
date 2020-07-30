package com.example.ComexPort.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.ComexPort.dto.UsuarioDto;
import com.example.ComexPort.repository.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTeste {


	@InjectMocks
	private UsuarioService usuarioService;

	@Mock
	private UsuarioRepository usuarioRepository;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
//	@Rule
//	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testeCadastrar() throws Exception {
		//cenario
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNome("fabio");
		usuarioDto.setEmail("fabio aoki");
		usuarioDto.setEndereco("rua osasco");
		usuarioDto.setDataAniversario(new Date(1993,9,11));
		//acao
		UsuarioDto Retorno = usuarioService.cadastrar(usuarioDto);
		Assert.assertNotNull(usuarioService.cadastrar(Retorno));
	}
	
	@Test
	public void testeCadastrarCamposObrigatoriosNulos() throws Exception {
		//cenario
		UsuarioDto usuarioDto = new UsuarioDto();
		//acao
		error.checkThat(usuarioDto.getNome(), is(nullValue()));
		error.checkThat(usuarioDto.getEmail(), is(nullValue()));
		error.checkThat(usuarioDto.getDataAniversario(), is(nullValue()));
	}
	
		
	@Test
	public void verificarEmailNaoExistenteNaBaseDeDados() throws Exception {
		//cenario
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setEmail("fabio@aoki.com");
		//acao
		Assert.assertEquals("email existente",null,usuarioService.verificar(usuarioDto.getEmail()));
	}
	
	@Test
	public void verificarEmailExistenteNaBaseDeDados() throws Exception {
		//cenario
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setEmail("fabio@aoki.com");
		//acao
		Assert.assertNotEquals("email nao existente","fabio@aoki.com",usuarioService.verificar(usuarioDto.getEmail()));
	}
}
