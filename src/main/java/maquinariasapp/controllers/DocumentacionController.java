package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/documentaciones")
public class DocumentacionController {
    @GetMapping(value="/documentacion/consultar/")
    public ResponseEntity<String> consultarPorId(){
        return new ResponseEntity<String>("Consulta por Codigo,Documentacion",null, HttpStatus.OK);
    }

    @GetMapping(value="/documentacion/consultar/maquinaria/")
    public ResponseEntity<String> consultarPorMaquinaria(){
        return new ResponseEntity<String>("Consulta toda lo disponible para maquinaria,Documentacion",null, HttpStatus.OK);
    }


}
