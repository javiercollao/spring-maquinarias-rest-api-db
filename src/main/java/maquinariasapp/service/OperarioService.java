package maquinariasapp.service;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Operario;
import maquinariasapp.repository.OperarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OperarioService {
    @Autowired
    private OperarioRepository operarioRepository;

    public List<Operario> obtenerTodosLosOperarios(){
        return operarioRepository.findAll().stream().toList();
    }

    public Operario crearNuevoOperario(Operario operario){
        return operarioRepository.save(operario);
    }

    public Operario obtenerOperarioPorId(Long operarioId){
        return operarioRepository.findById(operarioId).get();
    }

}
