package maquinariasapp.controllers;

import maquinariasapp.converters.RepuestoConverter;
import maquinariasapp.dtos.RepuestoDTO;
import maquinariasapp.entity.Repuesto;
import maquinariasapp.services.impl.RepuestoService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    @Autowired
    RepuestoService repuestoService;

    @Autowired
    RepuestoConverter repuestoConverter;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<RepuestoDTO>> crearNuevoRepuesto(
            @RequestBody RepuestoDTO repuesto
    ){
        Repuesto nuevoRepuesto = repuestoService.crearNuevoRepuesto(repuestoConverter.fromDTO(repuesto));
        RepuestoDTO response = repuestoConverter.fromEntity(nuevoRepuesto);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<List<RepuestoDTO>>> obtenerTodosLosRepuestos(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Repuesto> consulta = repuestoService.obtenerTodosLosRepuestos(page);
        List<RepuestoDTO> response = repuestoConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<RepuestoDTO>> obtenerRepuestoPorId(
            @PathVariable(value = "id") Long id
    ){
        Repuesto consulta = repuestoService.obtenerRepuestoPorId(id);
        RepuestoDTO response = repuestoConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<RepuestoDTO>> actualizarDatosRepuesto(
            @PathVariable(value = "id") Long id,
            @RequestBody RepuestoDTO repuesto
    ){
        Repuesto actualizarRepuesto = repuestoService.actualizarDatosDeRepuesto(id,repuestoConverter.fromDTO(repuesto));
        RepuestoDTO response = repuestoConverter.fromEntity(actualizarRepuesto);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

}
