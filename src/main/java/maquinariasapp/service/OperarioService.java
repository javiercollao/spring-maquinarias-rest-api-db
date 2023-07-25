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
        try {
            return operarioRepository.findAll().stream().toList();
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

}
