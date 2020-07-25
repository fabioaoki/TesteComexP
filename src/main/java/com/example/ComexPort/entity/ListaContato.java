package com.example.ComexPort.entity;

import java.io.Serializable;

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
@Table(name="lista_contato")
@NoArgsConstructor
@AllArgsConstructor
public class ListaContato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_usuario", nullable = true)
	private Long idUsuario;
	
	@Column(name = "tipo", nullable = true)
	private String tipo;
	
	@Column(name = "detalhe", nullable = true)
	private String detalhe;

}
