package maquinariasapp.converters;

import maquinariasapp.dtos.DocumentacionDTO;
import maquinariasapp.entity.Documentacion;

public class DocumentacionConverter extends AbstractConverter<Documentacion, DocumentacionDTO>{

    @Override
    public DocumentacionDTO fromEntity(Documentacion entity) {
        if(entity == null ) return null;
        return DocumentacionDTO.builder()
                .id_documentacion(entity.getId_documentacion())
                .desc_documentacion(entity.getDesc_documentacion())
                .nombre_documentacion(entity.getNombre_documentacion())
                .archivo_documentacion(entity.getArchivo_documentacion())
                .build();
    }

    @Override
    public Documentacion fromDTO(DocumentacionDTO dto) {
        if(dto == null ) return null;
        return Documentacion.builder()
                .
    }
}
