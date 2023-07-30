package maquinariasapp.controllers;

import maquinariasapp.dtos.ProveedorDTO;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> nuevoProveedor(@RequestBody ProveedorDTO proveedor){
        Proveedor nuevoProveedor = proveedorService.crearNuevoProveedor(proveedor);
        return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodasLosProveedores(){
        List<Proveedor> todosLosProveedores = proveedorService.obtenerTodosLosProveedores();
        return new ResponseEntity<>(todosLosProveedores, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Proveedor> consultarPorId(@PathVariable(value = "id") Long id){
        Proveedor obtenerProveedor = proveedorService.obtenerProveedorPorId(id);
        return new ResponseEntity<>(obtenerProveedor, HttpStatus.OK);
    }

    @GetMapping(value="/proveedor/actualizar/")
    public ResponseEntity<String> actualizarPorId(){
        return new ResponseEntity<String>("actualizar proveedor",null, HttpStatus.OK);
    }
}
