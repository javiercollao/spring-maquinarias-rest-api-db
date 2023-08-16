package maquinariasapp.services.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.ProveedorRepository;
import maquinariasapp.services.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    @Transactional
    public Proveedor crearNuevoProveedor(Proveedor proveedor) {
        try {
            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setNombre_proveedor(proveedor.getNombre_proveedor());
            return proveedorRepository.save(nuevoProveedor);
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
    public Proveedor obtenerProveedorPorId(Long id) {
        try{
            Proveedor registro = proveedorRepository.findById(id)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            return registro;
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
    public List<Proveedor> obtenerProveedores(Pageable page) {
        try{
            return proveedorRepository.findAll(page).toList();
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
    public Proveedor actualizarDatosProveedor(Long id, Proveedor proveedor) {
        try{
            Proveedor registro = proveedorRepository.findById(id)
                .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            registro.setNombre_proveedor(proveedor.getNombre_proveedor());
            return registro;
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
}
