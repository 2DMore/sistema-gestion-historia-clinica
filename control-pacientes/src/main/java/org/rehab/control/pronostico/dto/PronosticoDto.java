package org.rehab.control.pronostico.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Anotación para generar automáticamente getters, setters, toString, equals y hashCode
@AllArgsConstructor // Anotación para generar un constructor con todos los argumentos
public class PronosticoDto {
    private String pronostico;
    private Date fechaPronostico;
    private Long id;
    
}
