package com.BackendZemsania.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BackendZemsania.dto.RespPersonaDto;
import com.BackendZemsania.dto.ResponsePerDto;
import com.BackendZemsania.exceptions.LocationException;
import com.BackendZemsania.exceptions.MessageException;
import com.BackendZemsania.modelo.PersonaEntidad;
import com.BackendZemsania.servicio.IPersonaServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonaServicioImpl implements IPersonaServicio{
	@Override
	public RespPersonaDto obtenerPersona(String tipoDocumento, String numDocumento)
			throws MessageException, LocationException {
		
		System.out.println(validoTipoCedula(tipoDocumento));
		if(!validoTipoCedula(tipoDocumento)) throw new MessageException("El valor ingresado para tipoDocumento es incorrecto.");
		
		List<PersonaEntidad> persona = new ArrayList<>();
		PersonaEntidad per = PersonaEntidad.builder().id("1")
				.tipoDocumento("C").numDocumento("23445322").primerNombre("Juan")
				.segundoNombre("Andres").primerApellido("Gonzalez").segundoApellido("Ruiz")
				.ciudadResidencia("Bogota").direccion("cra 8#30a-17s").telefono("3456789")
				.build();
		persona.add(per);
		
		//List<ResponsePerDto> res = new ArrayList<>();
		ResponsePerDto dato = null;
		String mens = "No hay registro.";
		try {
			for(PersonaEntidad pers : persona) {
				if(pers.getTipoDocumento().equals(tipoDocumento) &&
				   per.getNumDocumento().equals(numDocumento)) {
					dato = ResponsePerDto.builder().primerNombre(pers.getPrimerNombre())
							.segundoNombre(pers.getSegundoNombre()).primerApellido(pers.getPrimerApellido())
							.segundoApellido(pers.getSegundoApellido()).ciudadResidencia(pers.getCiudadResidencia())
							.direccion(pers.getDireccion()).telefono(pers.getTelefono()).build();
					mens = "Exitoso.";
				}
					
			}
			
			return RespPersonaDto.builder().message(mens).datos(dato).build();
		}catch (Exception e) {
			throw new LocationException("No es posible crear usuarios, "+ e.getMessage());
		}
		
	}
	
	public boolean validoTipoCedula(String tipoDocumento) {
		switch (tipoDocumento) {
			case "C":
				return true;
			case "P":
				return true;
			default:
				return false;
		}
	}
}
