package maquinariasapp.controllers;

import maquinariasapp.entity.Operario;
import maquinariasapp.service.impl.OperarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operarios")
public class OperarioController {

    @Autowired
    OperarioService operarioService;

    @PostMapping
    public ResponseEntity<Operario> nuevoOperario(@RequestBody Operario operario){
        Operario nuevoOperario = operarioService.crearNuevoOperario(operario);
        return new ResponseEntity<>(nuevoOperario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Operario>> obtenerOperarios(){
        List<Operario> todosLosOperarios = operarioService.obtenerTodosLosOperarios();
        return new ResponseEntity<>(todosLosOperarios, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Operario> consultarPorId(@PathVariable(value = "id") Long id){
        Operario obtenerOperario = operarioService.obtenerOperarioPorId(id);
        return new ResponseEntity<>(obtenerOperario, HttpStatus.OK);
    }

}
