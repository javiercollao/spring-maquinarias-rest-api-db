package maquinariasapp.controllers;

import maquinariasapp.converters.ProveedorConverter;
import maquinariasapp.dtos.ProveedorDTO;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.services.impl.ProveedorService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @Autowired
    ProveedorConverter proveedorConverter;

    @PostMapping
    public ResponseEntity<WrapperResponse<ProveedorDTO>> nuevoProveedor(
            @RequestBody ProveedorDTO proveedor
    ){
        Proveedor nuevoProveedor = proveedorService.crearNuevoProveedor(proveedorConverter.fromDTO(proveedor));
        ProveedorDTO response = proveedorConverter.fromEntity(nuevoProveedor);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<ProveedorDTO>>> obtenerTodosLosProveedores(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Proveedor> todosLosProveedores = proveedorService.obtenerProveedores(page);
        List<ProveedorDTO> response = proveedorConverter.fromEntity(todosLosProveedores);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<WrapperResponse<ProveedorDTO>> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Proveedor obtenerProveedor = proveedorService.obtenerProveedorPorId(id);
        ProveedorDTO response = proveedorConverter.fromEntity(obtenerProveedor);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<WrapperResponse<ProveedorDTO>> actualizarDatosProveedor(
            @PathVariable(value = "id") Long id,
            @RequestBody ProveedorDTO proveedor
    ){
        Proveedor actualizarDatos = proveedorService.actualizarDatosProveedor(id, proveedorConverter.fromDTO(proveedor));
        ProveedorDTO response = proveedorConverter.fromEntity(actualizarDatos);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

}
