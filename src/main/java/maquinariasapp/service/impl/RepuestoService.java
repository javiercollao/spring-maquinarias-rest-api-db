package maquinariasapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Repuesto;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.RepuestoRepository;
import maquinariasapp.services.IRepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
@Slf4j
@Service
public class RepuestoService implements IRepuestoService {

    @Autowired
    RepuestoRepository repuestoRepository;

    @Override
    public Repuesto crearNuevoRepuesto(Repuesto repuesto) {
        try{
            return repuestoRepository.save(repuesto);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Repuesto> obtenerTodosLosRepuestos(Pageable page) {
        try{
            List<Repuesto> resultado = repuestoRepository.findAll(page).toList();
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
    public Repuesto obtenerRepuestoPorId(Long id) {
        try{
            Repuesto resultado = repuestoRepository.findById(id)
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
    public Repuesto actualizarDatosDeRepuesto(Long id, Repuesto repuesto) {
        try{
            Repuesto resultado = repuestoRepository.findById(id)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            resultado.setNombre_repuesto(repuesto.getNombre_repuesto());
            resultado.setDesc_repuesto(repuesto.getDesc_repuesto());
            return repuestoRepository.save(resultado);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
}
