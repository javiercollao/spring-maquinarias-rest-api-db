package maquinariasapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProveedorController {
    @GetMapping(value="/proveedor/ingresar/")
    public ResponseEntity<String> ingresarNuevo(){
        return new ResponseEntity<String>("Nuevo proveedor",null, HttpStatus.OK);
    }

    @GetMapping(value="/proveedor/actualizar/")
    public ResponseEntity<String> actualizarPorId(){
        return new ResponseEntity<String>("actualizar proveedor",null, HttpStatus.OK);
    }
}
