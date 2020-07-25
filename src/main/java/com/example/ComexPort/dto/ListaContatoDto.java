package com.example.ComexPort.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.example.ComexPort.entity.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaContatoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Usuario idUsuario;

	@NotEmpty(message = "tipo nao pode ser vazio.")
	private String tipo;

	@NotEmpty(message = "detalhe nao pode ser vazio.")
	private String detalhe;

}
