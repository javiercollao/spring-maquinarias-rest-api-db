package maquinariasapp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class OtDTO {
    private Long id_ot;
    private String desc_ot;
    private String observacion_ot;
    private String clase_mantenimiento_ot;
    private LocalDateTime fecha_ot;
    private LocalDateTime proxima_fecha_ot;
}
