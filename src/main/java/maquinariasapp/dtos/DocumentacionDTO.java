package maquinariasapp.dtos;

import lombok.*;
@Getter
@Setter
@Builder
public class DocumentacionDTO {
    private Long id_documentacion;
    private String desc_documentacion;
    private String nombre_documentacion;
    private String archivo_documentacion;
}
