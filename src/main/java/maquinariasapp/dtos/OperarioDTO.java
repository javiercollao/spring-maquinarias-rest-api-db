package maquinariasapp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class OperarioDTO {
    private Long id_operario;
    private String nombre_operario;
    private String correo_operario;
    private String apellido_operario;
    private String cargo_operario;
}
