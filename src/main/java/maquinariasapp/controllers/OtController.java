package maquinariasapp.controllers;

import maquinariasapp.converters.OtConverter;
import maquinariasapp.dtos.OtDTO;
import maquinariasapp.entity.Ot;
import maquinariasapp.services.impl.OtService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ots")
public class OtController {

    @Autowired
    OtService otService;

    @Autowired
    OtConverter otConverter;

    @PostMapping(value = "/operario/{id_operario}/maquinaria/{id_maquinaria}")
    public ResponseEntity<WrapperResponse<OtDTO>> crearNuevaOt(
            @RequestBody OtDTO ot,
            @PathVariable(value = "id_operario") Long idOperario,
            @PathVariable(value = "id_maquinaria") Long idMaquinaria
    ){
        Ot nuevaOt = otService.crearNuevaOt(idOperario, idMaquinaria, otConverter.fromDTO(ot));
        OtDTO response = otConverter.fromEntity(nuevaOt);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<OtDTO>>> obtenerOts(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Ot> todasLasOts = otService.obtenerTodasLasOt(page);
        List<OtDTO> response =  otConverter.fromEntity(todasLasOts);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value = "/maquinaria/{id}")
    public ResponseEntity<WrapperResponse<OtDTO>> obtenerOtPorIdMaquinaria(
            @PathVariable(value = "id") Long idMaquinaria
    ){
        Ot consulta = otService.obtenerUltimaOtDeMaquinaria(idMaquinaria);
        OtDTO response = otConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<WrapperResponse<OtDTO>> obtenerOtPorId(
            @PathVariable(value = "id") Long id
    ){
        Ot consulta = otService.obtenerOtPorId(id);
        OtDTO response = otConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<WrapperResponse<OtDTO>> actualizarDatosOt(
            @PathVariable(value = "id") Long id,
            @RequestBody OtDTO ot
    ){
        Ot consulta = otService.actualizarDatosDeOt(id, otConverter.fromDTO(ot));
        OtDTO response = otConverter.fromEntity(consulta);
        return new WrapperResponse<>(true, "success", response)
                .createResponse(HttpStatus.OK);
    }

}
