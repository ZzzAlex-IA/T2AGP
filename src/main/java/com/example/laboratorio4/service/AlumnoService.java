
package com.example.laboratorio4.service;

import com.example.laboratorio4.model.Alumno;
import com.example.laboratorio4.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    // Listar todos los alumnos
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    // Buscar alumno por ID
    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    // Registrar un alumno
    public Alumno registrar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    // Actualizar un alumno
    public Optional<Alumno> actualizar(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombres(alumnoActualizado.getNombres());
                    alumno.setCarrera(alumnoActualizado.getCarrera());
                    alumno.setCiclo(alumnoActualizado.getCiclo());
                    alumno.setPromedio(alumnoActualizado.getPromedio());

                    return alumnoRepository.save(alumno);
                });
    }

    // Eliminar un alumno
    public boolean eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            return false;
        }

        alumnoRepository.deleteById(id);
        return true;
    }
}
