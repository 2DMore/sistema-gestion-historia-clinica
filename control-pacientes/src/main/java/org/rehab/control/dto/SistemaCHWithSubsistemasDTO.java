package org.rehab.control.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data // Anotación para generar automáticamente getters, setters, toString, equals y hashCode
@AllArgsConstructor // Anotación para generar un constructor con todos los argumentos
public class SistemaCHWithSubsistemasDTO {
    private String sistemaNombre;
    private List<String> subSistemas;

    // Constructor, getters y setters
}

