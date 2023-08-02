package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ots")
public class OtController {
    @GetMapping(value="/ot/consultar/")
    public ResponseEntity<String> consultarOtPorId(){
        return new ResponseEntity<String>("Consulta por Codigo de maquinaria, OT",null, HttpStatus.OK);
    }

    @GetMapping(value="/ot/consultarFecha/")
    public ResponseEntity<String> consultarOtPorFecha(){
        return new ResponseEntity<String>("Consulta fecha de mantenimiento para maquinaria de OT",null, HttpStatus.OK);
    }

    @GetMapping(value="/ot/actualizarObservacion/")
    public ResponseEntity<String> actualizarOtObservacion(){
        return new ResponseEntity<String>("actualizar OT, observacion",null, HttpStatus.OK);
    }
}
