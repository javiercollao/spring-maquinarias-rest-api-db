package maquinariasapp.controllers;

import maquinariasapp.converters.ProveedorRepuestoConverter;
import maquinariasapp.dtos.ProveedorRepuestoDTO;
import maquinariasapp.entity.ProveedorRepuesto;
import maquinariasapp.services.impl.ProveedorRepuestoService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProveedorRepuestoController {

    @Autowired
    ProveedorRepuestoService proveedorRepuestoService;

    @Autowired
    ProveedorRepuestoConverter proveedorRepuestoConverter;

    @PostMapping(value="/proveedor/{id_proveedor}/repuesto/{id_repuesto}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<ProveedorRepuestoDTO>> crearRelacionProveedorRepuesto(
            @PathVariable(value = "id_proveedor") Long idProveedor,
            @PathVariable(value = "id_repuesto") Long idRepuesto,
            @RequestBody ProveedorRepuestoDTO proveedorRepuesto
    ){
        ProveedorRepuesto nuevoProducto = proveedorRepuestoService.crearRelacionProveedorRepuesto(proveedorRepuestoConverter.fromDTO(proveedorRepuesto),idRepuesto,idProveedor);
        ProveedorRepuestoDTO response = proveedorRepuestoConverter.fromEntity(nuevoProducto);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<String>> eliminarRelacion(
            @PathVariable(value = "id") Long idProveedorRepuesto
    ){
        String response = proveedorRepuestoService.eliminarRelacionProveedorRepuesto(idProveedorRepuesto);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value = "/proveedor/{proveedor_id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<List<ProveedorRepuestoDTO>>> obtenerTodosLosProductosSegunProveedor(
            @PathVariable(value = "proveedor_id") Long idProveedor
    ){
        List<ProveedorRepuesto> consulta = proveedorRepuestoService.obtenerRepuestosQueVendeProveedorPorId(idProveedor);
        List<ProveedorRepuestoDTO> response = proveedorRepuestoConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value = "/repuesto/{repuesto_id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<List<ProveedorRepuestoDTO>>> obtenerTodosLosProveedoresSegunRepuesto(
            @PathVariable(value = "repuesto_id") Long idRepuesto
    ){
        List<ProveedorRepuesto> consulta = proveedorRepuestoService.obtenerProveedoresQueVendenUnRepuestoPorId(idRepuesto);
        List<ProveedorRepuestoDTO> response = proveedorRepuestoConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<ProveedorRepuestoDTO>> actualizarDatosProducto(
            @PathVariable(value = "id") Long id,
            @RequestBody ProveedorRepuestoDTO proveedorRepuesto
    ){
        ProveedorRepuesto consulta = proveedorRepuestoService.actualizarDatosRelacionProveedorRepuesto(id,proveedorRepuestoConverter.fromDTO(proveedorRepuesto));
        ProveedorRepuestoDTO response = proveedorRepuestoConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

}
