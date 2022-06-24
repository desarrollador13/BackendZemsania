package com.BackendZemsania.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RespPersonaDto implements Serializable{
	
	private static final long serialVersionUID = -2583245140288277668L;
	
	private String message;
	private ResponsePerDto datos;

}
