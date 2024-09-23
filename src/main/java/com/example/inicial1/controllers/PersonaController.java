package com.example.inicial1.controllers;

import com.example.inicial1.dtos.PersonaDto;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class PersonaController {
    private PersonaServices personaService;

    public PersonaController(PersonaServices personaService){
        this.personaService = personaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");

        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");

        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.update(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");
        }
    }


}