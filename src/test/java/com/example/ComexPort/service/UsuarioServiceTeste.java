//package com.example.ComexPort.service;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Date;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.example.ComexPort.dto.UsuarioDto;
//import com.example.ComexPort.dto.UsuarioDtoTeste;
//import com.example.ComexPort.repository.UsuarioRepository;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UsuarioServiceTeste {
//
//
//	@InjectMocks
//	private UsuarioService usuarioService;
//
//	@Mock
//	private UsuarioDto usuarioDto;
//
//	@Mock
//	private UsuarioRepository usuarioRepository;
//
//	@Test
//	public void testeCadastrar() throws Exception {
//		usuarioDto.setNome("fabio aoki");
//		usuarioDto.setEmail("fabio@aoki.com");
//		usuarioDto.setDataAniversario(new Date(1993,9,11));
//		Assert.assertNotNull(usuarioDto);
//		when(usuarioService.cadastrar(usuarioDto)).thenReturn(usuarioDto);
//	}
//}
