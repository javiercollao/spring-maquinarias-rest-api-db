package maquinariasapp.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class ProveedorDTO {
    private Long id_proveedor;
    private String nombre_proveedor;

}
