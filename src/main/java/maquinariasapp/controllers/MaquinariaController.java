package maquinariasapp.controllers;

import maquinariasapp.converters.MaquinariaConverter;
import maquinariasapp.dtos.MaquinariaDTO;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.service.impl.MaquinariaService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maquinarias")
public class MaquinariaController {

    @Autowired
    MaquinariaService maquinariaService;

    @Autowired
    MaquinariaConverter maquinariaConverter;

    @PostMapping
    public ResponseEntity<WrapperResponse<MaquinariaDTO>> nuevaMaquinaria(
            @RequestBody MaquinariaDTO maquinaria
    ){
        Maquinaria nuevaMaquinaria = maquinariaService.crearNuevaMaquinaria(maquinariaConverter.fromDTO(maquinaria));
        MaquinariaDTO response = maquinariaConverter.fromEntity(nuevaMaquinaria);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<MaquinariaDTO>>> obtenerTodasLasMaquinarias(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Maquinaria> todosLasMaquinarias = maquinariaService.obtenerTodosLasMaquinarias(page);
        List<MaquinariaDTO> response = maquinariaConverter.fromEntity(todosLasMaquinarias);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<WrapperResponse<MaquinariaDTO>> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Maquinaria obtenerMaquinaria = maquinariaService.obtenerMaquinariaPorId(id);
        MaquinariaDTO response = maquinariaConverter.fromEntity(obtenerMaquinaria);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<WrapperResponse<MaquinariaDTO>> actualizarPorId(
            @PathVariable(value = "id") Long id,
            @RequestBody Maquinaria maquinaria
    ){
        Maquinaria actualizacionMaquinaria = maquinariaService.actualizarMaquinaria(id, maquinaria);
        MaquinariaDTO response = maquinariaConverter.fromEntity(actualizacionMaquinaria);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }
}
