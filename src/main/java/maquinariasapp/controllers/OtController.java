package maquinariasapp.controllers;

import maquinariasapp.entity.Ot;
import maquinariasapp.service.impl.OtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ots")
public class OtController {

    @Autowired
    OtService otService;
    @GetMapping
    public ResponseEntity<List<Ot>> obtenerOts(){
        List<Ot> todasLasOts = otService.obtenerTodasLasOts();
        return new ResponseEntity<>(todasLasOts, HttpStatus.OK);
    }


}
