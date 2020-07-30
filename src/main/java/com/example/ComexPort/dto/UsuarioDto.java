package com.example.ComexPort.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDto implements Serializable {
	
	private static final long serialVersionUID = -6978454629460201327L;
	
	private Long id;
	
	@NotEmpty(message = "nome nao pode ser vazio.")
	@Length(min = 5, max = 255, message = "nome deve conter entre 5 a 200 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Email nao pode ser vazio.")
	private String email;
	
	@NotNull
	@Past
	private Date dataAniversario;
	
	private String endereco;
	private Date dataCriacao;
	private Date dataModificacao;
	
	private int idade;

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

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nome=" + nome + ", email=" + email + ", dataAniversario=" + dataAniversario
				+ ", endereco=" + endereco + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao
				+ ", idade=" + idade + "]";
	}

	public UsuarioDto() {
	}

	
}
