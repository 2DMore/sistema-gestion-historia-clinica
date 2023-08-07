package org.rehab.control.exploracionFisica.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Anotación para generar automáticamente getters, setters, toString, equals y hashCode
@AllArgsConstructor // Anotación para generar un constructor con todos los argumentos
public class ExploracionFisicaDto {
    private String exploracionFisica;
    private Date fechaExploracion;
    private Long id;
    
}
