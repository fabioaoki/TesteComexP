package com.example.ComexPort.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto implements Serializable {
	
	private static final long serialVersionUID = -6978454629460201327L;
	
	private Long id;
	
	@NotEmpty(message = "nome nao pode ser vazio.")
	@Length(min = 5, max = 255, message = "nome deve conter entre 5 a 200 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Email nao pode ser vazio.")
	private String email;
	
	//trocar para String dataNascimento
	@NotEmpty(message = "data de nascimento nao pode ser vazio")
	private String dataAniversario;
	
	private String endereco;
	private Date dataCriacao;
	private Date dataModificacao;

	@PrePersist
    public UsuarioDto prePersist(UsuarioDto usuarioDto) {
        final Date atual = new Date();
        if(usuarioDto.dataCriacao == null) {
        	usuarioDto.setDataCriacao(atual);
        	return usuarioDto;
        }else {
        	usuarioDto.setDataModificacao(atual);
        	return usuarioDto;
        }
    }

}
