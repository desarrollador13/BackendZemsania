package com.BackendZemsania.dto;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
public class PersonaDto implements Serializable{
	
	private static final long serialVersionUID = -2583245140288277668L;
	
	@SuppressWarnings("deprecation")
	@NotEmpty(message = "El campo tipoDocumento no puede ser vacio.")
	//@NotNull(message = "El campo tipoDocumento no puede ser null.")
	@Size(min = 1, max = 1, message = "El tipo maximo de caracteres para tipoDocumento es 1.")
	private String tipoDocumento;
	@SuppressWarnings("deprecation")
	@NotEmpty(message = "El campo numDocumento no puede ser vacio.")
	//@NotNull(message = "El campo numDocumento no puede ser null.")
	private String numDocumento;
}
