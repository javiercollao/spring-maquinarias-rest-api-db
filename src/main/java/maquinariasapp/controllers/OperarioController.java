package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperarioController {
    @GetMapping(value="/operario/ingresar/")
    public ResponseEntity<String> nuevoOperario(){
        return new ResponseEntity<String>("nuevo operario",null, HttpStatus.OK);
    }

    @GetMapping(value="/operario/consultar/")
    public ResponseEntity<String> consultarPorId(){
        return new ResponseEntity<String>("Consulta por Codigo,Operario",null, HttpStatus.OK);
    }
}
