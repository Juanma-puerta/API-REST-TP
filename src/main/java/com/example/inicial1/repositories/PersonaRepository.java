package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    boolean existByDni(int)
}