package maquinariasapp.controllers;

import maquinariasapp.converters.DocumentacionConverter;
import maquinariasapp.dtos.DocumentacionDTO;
import maquinariasapp.entity.Documentacion;
import maquinariasapp.service.impl.DocumentacionService;
import maquinariasapp.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/documentaciones")
public class DocumentacionController {

    @Autowired
    DocumentacionService documentacionService;

    @Autowired
    DocumentacionConverter documentacionConverter;

    @PostMapping
    public ResponseEntity<WrapperResponse<DocumentacionDTO>> crearDocumentacion(
            @RequestBody DocumentacionDTO documentacionDTO
    ){
        Documentacion doc = documentacionService.crearNuevaDocumentacion(documentacionConverter.fromDTO(documentacionDTO));
        DocumentacionDTO registroDTO = documentacionConverter.fromEntity(doc);
        return new WrapperResponse<>(true, "success", registroDTO)
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<DocumentacionDTO>>> obtenerTodasLasDocumentaciones(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Documentacion> docs =  documentacionService.obtenerTodasLasDocumentaciones(page);

        if (docs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <DocumentacionDTO> docsDTO = documentacionConverter.fromEntity(docs);
        return new WrapperResponse<>(true, "success", docsDTO)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<WrapperResponse<DocumentacionDTO>> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Documentacion doc = documentacionService.obtenerDocumentacionPorId(id);
        if(doc == null){
            return ResponseEntity.noContent().build();
        }
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new WrapperResponse<>(true, "success", docDTO)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping (value="/{id}")
    public ResponseEntity<WrapperResponse<DocumentacionDTO>> actualizarDocumentacion(
            @PathVariable(value = "id") Long id,
            @RequestBody DocumentacionDTO documentacionDTO
    ){
        Documentacion doc = documentacionService.actualizarDocumentacion(id, documentacionConverter.fromDTO(documentacionDTO));
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new WrapperResponse<>(true, "success", docDTO)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping (value="/{id_documentacion}/asignar-maquinaria/{id_maquinaria}")
    public ResponseEntity<DocumentacionDTO> agregarDocumentacionAMaquinaria(
            @PathVariable(value = "id_documentacion") Long id_documentacion,
            @PathVariable(value = "id_maquinaria") Long id_maquinaria
    ){
        Documentacion doc = documentacionService.asignarMaquinariaADocumentacion(id_documentacion,id_maquinaria);
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new ResponseEntity<>(docDTO,HttpStatus.OK);
    }

    @PutMapping (value="/{id_documentacion}/quitar-maquinaria/{id_maquinaria}")
    public ResponseEntity<DocumentacionDTO> eliminarRelacionDeMaquinariaConDocumentacion(
            @PathVariable(value = "id_documentacion") Long id_documentacion,
            @PathVariable(value = "id_maquinaria") Long id_maquinaria
    ){
        Documentacion doc = documentacionService.eliminarDocumentacionDeMaquinaria(id_documentacion,id_maquinaria);
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new ResponseEntity<>(docDTO,HttpStatus.OK);
    }

}
