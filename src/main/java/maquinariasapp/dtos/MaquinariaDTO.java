package maquinariasapp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class MaquinariaDTO {
    private Long id_maquinaria;
    private String patente_maquinaria;
    private String nombre_maquinaria;
    private String tipo_maquinaria;
    private String precio_compra_maquinaria;
    private String frecuencia_mantenimiento_maquinaria;
    private String horometro_maquinaria;
}
