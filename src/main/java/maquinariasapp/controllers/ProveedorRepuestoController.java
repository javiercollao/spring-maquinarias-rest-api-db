package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProveedorRepuestoController {
    @GetMapping(value="/proveedor/repuesto/ingresar/")
    public ResponseEntity<String> ingresarRelacion(){
        return new ResponseEntity<String>("ingresar repuesto proveedor",null, HttpStatus.OK);
    }

    @GetMapping(value="/proveedor/repuesto/")
    public ResponseEntity<String> eliminarRelacion(){
        return new ResponseEntity<String>("borrar repuesto de proveedor",null, HttpStatus.OK);
    }
}
