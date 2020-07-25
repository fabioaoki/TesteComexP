package com.example.ComexPort.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdadeDto implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private int idade;

}
