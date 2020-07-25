package com.example.ComexPort.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Getter
@Setter
@Table(name="usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "endereco", nullable = true)
	private String endereco;
	
	@Column(name = "data_aniversario" , nullable = false)
	private Date dataAniversario;
	
	@Column(name = "data_criacao", nullable = true)
	private Date dataCriacao;
	
	@Column(name = "data_modificacao")
	private Date dataModificacao;

}
