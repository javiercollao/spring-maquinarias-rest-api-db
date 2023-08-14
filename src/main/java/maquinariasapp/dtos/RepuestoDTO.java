package maquinariasapp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class RepuestoDTO {
    private Long id_repuesto;
    private String desc_repuesto;
    private String nombre_repuesto;
}
