package maquinariasapp.controllers;

import maquinariasapp.dtos.MaquinariaDTO;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.service.impl.MaquinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maquinarias")
public class MaquinariaController {

    @Autowired
    MaquinariaService maquinariaService;

    @PostMapping
    public ResponseEntity<Maquinaria> nuevaMaquinaria(@RequestBody MaquinariaDTO maquinaria){
        Maquinaria nuevaMaquinaria = maquinariaService.crearNuevaMaquinaria(maquinaria);
        return new ResponseEntity<>(nuevaMaquinaria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Maquinaria>> obtenerTodasLasMaquinarias(){
        List<Maquinaria> todosLasMaquinarias = maquinariaService.obtenerTodosLasMaquinarias();
        return new ResponseEntity<>(todosLasMaquinarias, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Maquinaria> consultarPorId(@PathVariable(value = "id") Long id){
        Maquinaria obtenerMaquinaria = maquinariaService.obtenerMaquinariaPorId(id);
        return new ResponseEntity<>(obtenerMaquinaria, HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Maquinaria> actualizarPorId(@PathVariable(value = "id") Long id, @RequestBody MaquinariaDTO maquinaria){
        Maquinaria actualizacionMaquinaria = maquinariaService.actualizarDatosMaquinaria(id, maquinaria);
        return new ResponseEntity<>(actualizacionMaquinaria, HttpStatus.OK);
    }
}
