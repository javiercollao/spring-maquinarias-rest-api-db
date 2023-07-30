package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    @GetMapping(value="/repuesto/consultar/")
    public ResponseEntity<String> consultarPorId(){
        return new ResponseEntity<String>("Consulta por Codigo,Repuesto",null, HttpStatus.OK);
    }

    @GetMapping(value="/repuesto/actualizar/")
    public ResponseEntity<String> actualizarPorId(){
        return new ResponseEntity<String>("Actualizar por codigo, Repuesto",null, HttpStatus.OK);
    }

    @GetMapping(value="/repuesto/ingresar/")
    public ResponseEntity<String> IngresarNuevo(){
        return new ResponseEntity<String>("Ingresar nuevo Repuesto",null, HttpStatus.OK);
    }
}
