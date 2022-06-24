package com.BackendZemsania.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.BackendZemsania.constante.Endpoint;
import com.BackendZemsania.dto.PersonaDto;
import com.BackendZemsania.dto.RespPersonaDto;
import com.BackendZemsania.exceptions.LocationException;
import com.BackendZemsania.exceptions.MessageException;
import com.BackendZemsania.servicio.IPersonaServicio;
import org.springframework.web.server.ResponseStatusException;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Endpoint.PERSONA_ENDPOINT)
public class PersonaControlador {
	
	@Autowired
	private IPersonaServicio personaServicio;
	
	@PostMapping
	public ResponseEntity<RespPersonaDto> obtenerPersona(@Valid @RequestBody PersonaDto body) throws MessageException, LocationException {
		try {
			RespPersonaDto res = personaServicio.obtenerPersona(body.getTipoDocumento(), body.getNumDocumento());
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (MessageException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }catch (LocationException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
		
		
	}

}
