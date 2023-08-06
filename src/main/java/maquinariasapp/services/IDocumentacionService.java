package maquinariasapp.services;

import maquinariasapp.entity.Documentacion;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDocumentacionService {
    public List<Documentacion> obtenerTodasLasDocumentaciones(Pageable page);
    public Documentacion obtenerDocumentacionPorId(Long documentacionId);
    public Documentacion crearNuevaDocumentacion(Documentacion documentacion);
    public Documentacion actualizarDocumentacion(Documentacion documentacion);

}
