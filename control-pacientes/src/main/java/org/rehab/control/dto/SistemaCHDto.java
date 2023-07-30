package org.rehab.control.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotación para generar automáticamente getters, setters, toString, equals y hashCode
@AllArgsConstructor // Anotación para generar un constructor con todos los argumentos
@NoArgsConstructor // Anotación para generar un constructor sin argumentos
public class SistemaCHDto {
   
    private String sistemaNombre;
    
}