package maquinariasapp.controllers;

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

    @PostMapping
    public ResponseEntity<Documentacion> crearDocumentacion(
            @RequestBody Documentacion documentacion
    ){
        Documentacion doc = documentacionService.crearNuevaDocumentacion(documentacion);
        return new ResponseEntity<>(doc, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Documentacion>> obtenerTodasLasDocumentaciones(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize
    ){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Documentacion> docs =  documentacionService.obtenerTodasLasDocumentaciones(page);

        if (docs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(docs, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Documentacion> consultarPorId(
            @PathVariable(value = "id") Long id
    ){
        Documentacion doc = documentacionService.obtenerDocumentacionPorId(id);
        if(doc == null){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }

    @PutMapping (value="/{id}")
    public ResponseEntity<Documentacion> actualizarDocumentacion(
            @PathVariable(value = "id") Long id,
            @RequestBody Documentacion documentacion
    ){
        Documentacion doc = documentacionService.actualizarDocumentacion(id, documentacion);
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }

}
