package maquinariasapp.service.impl;

import maquinariasapp.entity.Documentacion;
import maquinariasapp.repository.DocumentacionRepository;
import maquinariasapp.services.IDocumentacionService;
import maquinariasapp.validators.DocumentacionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;


@Service
public class DocumentacionService implements IDocumentacionService {

    @Autowired
    DocumentacionRepository documentacionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Documentacion> obtenerTodasLasDocumentaciones(Pageable page) {
        try{
            return documentacionRepository.findAll(page).toList();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Documentacion obtenerDocumentacionPorId(Long documentacionId) {
        try {
            Documentacion resultado = documentacionRepository.findById(documentacionId).orElseThrow();
            return resultado;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Documentacion crearNuevaDocumentacion(Documentacion documentacion) {
        try {
            DocumentacionValidator.validacionDeGuardado(documentacion);
            return documentacionRepository.save(documentacion);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Documentacion actualizarDocumentacion(Long id, Documentacion documentacion) {
        try {
            DocumentacionValidator.validacionDeGuardado(documentacion);
            Documentacion registro = documentacionRepository.findById(id).orElseThrow();
            registro.setNombre_documentacion(documentacion.getNombre_documentacion());
            registro.setDesc_documentacion(documentacion.getDesc_documentacion());
            registro.setArchivo_documentacion(documentacion.getArchivo_documentacion());
            return documentacionRepository.save(registro);
        }catch (Exception e){
            return null;
        }
    }

}
