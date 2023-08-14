package maquinariasapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Operario;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.OperarioRepository;
import maquinariasapp.services.IOperarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Slf4j
@Service
public class OperarioService implements IOperarioService {
    @Autowired
    private OperarioRepository operarioRepository;


    @Override
    public List<Operario> obtenerOperariosRegistrados(Pageable page) {
        try{
            return operarioRepository.findAll(page).toList();
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Operario obtenerOperarioPorId(Long idOperario) {
        try{
            Operario resultado = operarioRepository.findById(idOperario)
            .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            return resultado;
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Operario crearNuevoOperario(Operario operario) {
        try{
            return operarioRepository.save(operario);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Operario actualizarDatosOperario(Long idOperario, Operario operario) {
        try{
            Operario registro = operarioRepository.findById(idOperario)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            registro.setCorreo_operario(operario.getCorreo_operario());
            registro.setNombre_operario(operario.getNombre_operario());
            registro.setApellido_operario(operario.getApellido_operario());
            registro.setCargo_operario(operario.getCargo_operario());
            return operarioRepository.save(registro);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
}
