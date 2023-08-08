package maquinariasapp.controllers;

import maquinariasapp.converters.DocumentacionConverter;
import maquinariasapp.dtos.DocumentacionDTO;
import maquinariasapp.entity.Documentacion;
import maquinariasapp.service.impl.DocumentacionService;
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
    public ResponseEntity<DocumentacionDTO> crearDocumentacion(
            @RequestBody DocumentacionDTO documentacionDTO
    ){
        Documentacion doc = documentacionService.crearNuevaDocumentacion(documentacionConverter.fromDTO(documentacionDTO));
        DocumentacionDTO registroDTO = documentacionConverter.fromEntity(doc);
        return new ResponseEntity<>(registroDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DocumentacionDTO>> obtenerTodasLasDocumentaciones(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Documentacion> docs =  documentacionService.obtenerTodasLasDocumentaciones(page);

        if (docs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <DocumentacionDTO> docsDTO = documentacionConverter.fromEntity(docs);
        return new ResponseEntity<>(docsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<DocumentacionDTO> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Documentacion doc = documentacionService.obtenerDocumentacionPorId(id);
        if(doc == null){
            return ResponseEntity.noContent().build();
        }
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new ResponseEntity<>(docDTO, HttpStatus.OK);
    }

    @PutMapping (value="/{id}")
    public ResponseEntity<DocumentacionDTO> actualizarDocumentacion(
            @PathVariable(value = "id") Long id,
            @RequestBody DocumentacionDTO documentacionDTO
    ){
        Documentacion doc = documentacionService.actualizarDocumentacion(id, documentacionConverter.fromDTO(documentacionDTO));
        DocumentacionDTO docDTO = documentacionConverter.fromEntity(doc);
        return new ResponseEntity<>(docDTO, HttpStatus.OK);
    }

}
