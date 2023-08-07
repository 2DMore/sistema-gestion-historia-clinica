package org.rehab.control.archivos.service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.rehab.control.archivos.dto.ArchivoDTO;
import org.rehab.control.archivos.entity.Archivo;
import org.rehab.control.archivos.repository.ArchivoRepository;
import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.fi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void guardarArchivo(MultipartFile file, Long numExpediente) throws IOException {

        String nombreArchivo = file.getOriginalFilename();
        Path basePath = Paths.get(System.getProperty("user.dir"), "//control-pacientes//uploads//");
        Path pathCompleto = basePath.resolve(nombreArchivo);

        Files.write(pathCompleto, file.getBytes());

        Paciente paciente = pacienteRepository.findById(numExpediente).orElse(null);
        if (paciente != null) {
            Archivo archivo = new Archivo();
            archivo.setNombreArchivo(nombreArchivo);
            archivo.setPaciente(paciente);
            archivoRepository.save(archivo);
        } else {
            throw new IllegalArgumentException("El expediente con numero " + numExpediente + " no existe.");
        }
    }

    public ArchivoDTO obtenerArchivoPorId(Long idArchivo) {
        Archivo archivo = archivoRepository.findById(idArchivo).orElse(null);
        if (archivo != null) {
            ArchivoDTO archivoDTO = new ArchivoDTO();
            archivoDTO.setId(archivo.getId());
            archivoDTO.setNombreArchivo(archivo.getNombreArchivo());
            return archivoDTO;
        }
        return null;
    }

    public byte[] descargarArchivo(String nombreArchivo) throws IOException {

        Path basePath = Paths.get(System.getProperty("user.dir"), "//control-pacientes//uploads//");
        Path pathCompleto = basePath.resolve(nombreArchivo);
        return Files.readAllBytes(pathCompleto);
    }
}

