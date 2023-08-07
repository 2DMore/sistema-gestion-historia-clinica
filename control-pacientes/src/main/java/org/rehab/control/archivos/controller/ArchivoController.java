package org.rehab.control.archivos.controller;
import org.rehab.control.archivos.dto.ArchivoDTO;
import org.rehab.control.archivos.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @PostMapping("/upload/{idPersona}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long idPersona) {
        try {
            archivoService.guardarArchivo(file, idPersona);
            return ResponseEntity.ok("Archivo cargado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al cargar el archivo.");
        }
    }

    @GetMapping("/archivo/{idArchivo}")
    public ResponseEntity<ByteArrayResource> visualizarArchivo(@PathVariable Long idArchivo) {
        ArchivoDTO archivoDTO = archivoService.obtenerArchivoPorId(idArchivo);
        if (archivoDTO == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            byte[] contenido = archivoService.descargarArchivo(archivoDTO.getNombreArchivo());
            ByteArrayResource resource = new ByteArrayResource(contenido);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + archivoDTO.getNombreArchivo() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) // O utiliza el tipo de contenido adecuado para tu caso
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            //return ResponseEntity.status(500).body("Error al visualizar el archivo.");
        }
        return null;
    }
}
