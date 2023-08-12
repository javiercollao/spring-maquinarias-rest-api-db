package maquinariasapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Documentacion;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.DocumentacionRepository;
import maquinariasapp.repository.MaquinariaRepository;
import maquinariasapp.services.IDocumentacionService;
import maquinariasapp.validators.DocumentacionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DocumentacionService implements IDocumentacionService {

    @Autowired
    DocumentacionRepository documentacionRepository;

    @Autowired
    MaquinariaRepository maquinariaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Documentacion> obtenerTodasLasDocumentaciones(Pageable page) {
        try{
            return documentacionRepository.findAll(page).toList();
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Documentacion> obtenerDocumentacionesDeMaquinaria(Pageable page, Long maquinariaId) {
        try{
            List<Documentacion> all = documentacionRepository.findAll(page).toList();
            List<Documentacion> docs = all.stream()
                    .filter(doc -> doc.getMaquinarias().stream()
                            .anyMatch(maquinaria -> Objects.equals(maquinaria.getId_maquinaria(), maquinariaId)))
                    .collect(Collectors.toList());
            return docs;
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
    public Documentacion obtenerDocumentacionPorId(Long documentacionId) {
        try {
            Documentacion resultado = documentacionRepository.findById(documentacionId)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            return resultado;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Documentacion crearNuevaDocumentacion(Documentacion documentacion) {
        try {
            DocumentacionValidator.validacionDeGuardado(documentacion);
            return documentacionRepository.save(documentacion);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Documentacion actualizarDocumentacion(Long id, Documentacion documentacion) {
        try {
            DocumentacionValidator.validacionDeGuardado(documentacion);
            Documentacion registro = documentacionRepository.findById(id)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            registro.setNombre_documentacion(documentacion.getNombre_documentacion());
            registro.setDesc_documentacion(documentacion.getDesc_documentacion());
            registro.setArchivo_documentacion(documentacion.getArchivo_documentacion());
            return documentacionRepository.save(registro);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Documentacion asignarMaquinariaADocumentacion(Long id_documentacion, Long id_maquinaria) {
        try{
            Maquinaria maquinaria = maquinariaRepository.findById(id_maquinaria)
                    .orElseThrow(()-> new NoDataFoundException("No existe maquinaria con ese ID."));
            Documentacion documentacion = documentacionRepository.findById(id_documentacion)
                    .orElseThrow(()-> new NoDataFoundException("No existe documentación con ese ID."));
            List<Maquinaria> maquinarias = documentacion.getMaquinarias();
            boolean existeMaquinaria = maquinarias.stream()
                    .anyMatch(maq -> Objects.equals(maq.getId_maquinaria(), maquinaria.getId_maquinaria()));
            if (!existeMaquinaria) {
                maquinarias.add(maquinaria);
                return documentacionRepository.save(documentacion);
            }
            return documentacion;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Documentacion eliminarDocumentacionDeMaquinaria(Long id_documentacion, Long id_maquinaria) {
        try{
            Maquinaria maquinaria = maquinariaRepository.findById(id_maquinaria)
                    .orElseThrow(()-> new NoDataFoundException("No existe maquinaria con ese ID."));
            Documentacion documentacion = documentacionRepository.findById(id_documentacion)
                    .orElseThrow(()-> new NoDataFoundException("No existe documentación con ese ID."));
            List <Maquinaria> maquinarias = documentacion.getMaquinarias();
            List <Maquinaria> nuevas_maquinarias = maquinarias.stream()
                    .filter(maq -> !Objects.equals(maq.getId_maquinaria(), maquinaria.getId_maquinaria()))
                    .collect(Collectors.toList());
            documentacion.setMaquinarias(nuevas_maquinarias);
            return documentacionRepository.save(documentacion);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

}
