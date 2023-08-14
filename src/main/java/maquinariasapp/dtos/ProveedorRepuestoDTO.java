package maquinariasapp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class ProveedorRepuestoDTO {
    private Long id_prov_rep;
    private Integer cantidad_repuesto;
}
