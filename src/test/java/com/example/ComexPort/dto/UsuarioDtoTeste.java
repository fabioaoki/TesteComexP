//package com.example.ComexPort.dto;
//
//import java.util.Date;
//
//public class UsuarioDtoTeste {
//
//	private UsuarioDto usuarioDto;
//	
//	public UsuarioDtoTeste() {}
//	
//	public static UsuarioDtoTeste cadastroTodosOsCampos(){
//		UsuarioDtoTeste usuarioDtoTeste = new UsuarioDtoTeste();
//		usuarioDtoTeste.usuarioDto = new UsuarioDto(null, "fabio aoki", "fabio@aoki.com", new Date(1993, 9, 11), "rua osasco", null, null, 0);
//		return usuarioDtoTeste;
//	}
//	
//	public static UsuarioDtoTeste cadastroCamposObrigatorios(){
//		UsuarioDtoTeste usuarioDtoTeste = new UsuarioDtoTeste();
//		usuarioDtoTeste.usuarioDto = new UsuarioDto(null, "fabio aoki", "fabio@aoki.com", new Date(1993, 9, 11), null, null, null, 0);
//		return usuarioDtoTeste;
//	}
//	
//	public static UsuarioDtoTeste cadastroCamposObrigatoriosNulos(){
//		UsuarioDtoTeste usuarioDtoTeste = new UsuarioDtoTeste();
//		usuarioDtoTeste.usuarioDto = new UsuarioDto(1L, null, "fabio@aoki.com", new Date(1993, 9, 11), "rua osasco", null, null, 0);
//		return usuarioDtoTeste;
//	}
//	
//	public UsuarioDtoTeste comNome(String nome) {
//		usuarioDto.setNome(nome);
//		return this;
//	}
//	
//	public UsuarioDto agora(){
//		return usuarioDto;
//	}
//}
