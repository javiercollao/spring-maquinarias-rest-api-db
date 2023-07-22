package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaquinariaController {
    @GetMapping(value="/maquinaria/ingresar/")
    public ResponseEntity<String> ingresarNueva(){
        return new ResponseEntity<String>("nueva maquinaria",null, HttpStatus.OK);
    }

    @GetMapping(value="/maquinaria/consultar/")
    public ResponseEntity<String> consultarPorId(){
        return new ResponseEntity<String>("Consulta por Codigo,Maquinaria",null, HttpStatus.OK);
    }

    @GetMapping(value="/maquinaria/actualizar/")
    public ResponseEntity<String> actualizarPorId(){
        return new ResponseEntity<String>("actualizar por Codigo,Maquinaria",null, HttpStatus.OK);
    }
}
