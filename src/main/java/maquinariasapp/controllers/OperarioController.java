package maquinariasapp.controllers;

import maquinariasapp.converters.OperarioConverter;
import maquinariasapp.dtos.OperarioDTO;
import maquinariasapp.entity.Operario;
import maquinariasapp.services.impl.OperarioService;
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
@RequestMapping("/api/v1/operarios")
public class OperarioController {

    @Autowired
    OperarioService operarioService;

    @Autowired
    OperarioConverter operarioConverter;

    @PostMapping
    public ResponseEntity<WrapperResponse<OperarioDTO>> nuevoOperario(
            @RequestBody Operario operario
    ){
        Operario nuevoOperario = operarioService.crearNuevoOperario(operario);
        OperarioDTO response = operarioConverter.fromEntity(nuevoOperario);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<List<OperarioDTO>>> obtenerOperarios(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Operario> todosLosOperarios = operarioService.obtenerOperariosRegistrados(page);
        List<OperarioDTO> response = operarioConverter.fromEntity(todosLosOperarios);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ROLE_MECANICO') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<OperarioDTO>> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Operario obtenerOperario = operarioService.obtenerOperarioPorId(id);
        OperarioDTO response = operarioConverter.fromEntity(obtenerOperario);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<WrapperResponse<OperarioDTO>> actualizarDatosOperarios(
            @PathVariable(value = "id") Long id,
            @RequestBody OperarioDTO operario
    ){
        Operario actualizarOperario = operarioService.actualizarDatosOperario(id, operarioConverter.fromDTO(operario));
        OperarioDTO response = operarioConverter.fromEntity(actualizarOperario);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

}
