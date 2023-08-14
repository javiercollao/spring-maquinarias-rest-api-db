package maquinariasapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.entity.ProveedorRepuesto;
import maquinariasapp.entity.Repuesto;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.ProveedorRepository;
import maquinariasapp.repository.ProveedorRepuestoRepository;
import maquinariasapp.repository.RepuestoRepository;
import maquinariasapp.services.IProveedorRepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
@Slf4j
@Service
public class ProveedorRepuestoService implements IProveedorRepuestoService {
    @Autowired
    ProveedorRepuestoRepository proveedorRepuestoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    RepuestoRepository repuestoRepository;


    @Override
    @Transactional
    public ProveedorRepuesto crearRelacionProveedorRepuesto(ProveedorRepuesto proveedorRepuesto, Long repuestoId, Long proveedorId) {
        try{
            Proveedor registroProveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro de proveedor con ese ID."));

            Repuesto registroRepuesto = repuestoRepository.findById(repuestoId)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro de repuesto con ese ID."));
            
            ProveedorRepuesto resultado = new ProveedorRepuesto();
            resultado.setCantidad_repuesto(proveedorRepuesto.getCantidad_repuesto());
            resultado.setRepuesto(registroRepuesto);
            resultado.setProveedor(registroProveedor);
            return proveedorRepuestoRepository.save(resultado);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public String eliminarRelacionProveedorRepuesto(Long proveedorRepuestoId) {
        try{
            ProveedorRepuesto registro = proveedorRepuestoRepository.findById(proveedorRepuestoId)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            proveedorRepuestoRepository.delete(registro);
            return "Registro eliminado correctamente";
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorRepuesto> obtenerRepuestosQueVendeProveedorPorId(Long proveedorId) {
        try{
            Proveedor registroProveedor = proveedorRepository.findById(proveedorId)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro de proveedor con ese ID."));
            List<ProveedorRepuesto> all = proveedorRepuestoRepository.findAll();
            List<ProveedorRepuesto> resultado = all.stream()
                    .filter(proveedorRepuesto -> Objects.equals(proveedorRepuesto.getProveedor(),registroProveedor)).toList();
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
    @Transactional(readOnly = true)
    public List<ProveedorRepuesto> obtenerProveedoresQueVendenUnRepuestoPorId(Long repuestoId) {
        try{
            Repuesto registroRepuesto = repuestoRepository.findById(repuestoId)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro de repuesto con ese ID."));
            List<ProveedorRepuesto> all = proveedorRepuestoRepository.findAll();
            List<ProveedorRepuesto> resultado = all.stream()
                    .filter(proveedorRepuesto -> Objects.equals(proveedorRepuesto.getRepuesto(),registroRepuesto)).toList();
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
    @Transactional
    public ProveedorRepuesto actualizarDatosRelacionProveedorRepuesto(Long proveedorRepuestoId, ProveedorRepuesto proveedorRepuesto) {
        try{
            ProveedorRepuesto registro = proveedorRepuestoRepository.findById(proveedorRepuestoId)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            registro.setCantidad_repuesto(proveedorRepuesto.getCantidad_repuesto());
            return proveedorRepuestoRepository.save(registro);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
}
