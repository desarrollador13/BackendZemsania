package com.BackendZemsania.servicio;

import com.BackendZemsania.dto.RespPersonaDto;
import com.BackendZemsania.exceptions.LocationException;
import com.BackendZemsania.exceptions.MessageException;

public interface IPersonaServicio {
	RespPersonaDto obtenerPersona(String tipoDocumento, String numDocumento)throws MessageException, LocationException;
}
