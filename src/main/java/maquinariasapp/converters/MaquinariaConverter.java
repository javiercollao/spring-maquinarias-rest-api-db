package maquinariasapp.converters;

import maquinariasapp.dtos.MaquinariaDTO;
import maquinariasapp.entity.Maquinaria;
import org.springframework.stereotype.Component;

@Component
public class MaquinariaConverter extends AbstractConverter<Maquinaria, MaquinariaDTO>{
    @Override
    public MaquinariaDTO fromEntity(Maquinaria entity) {
        if(entity == null ) return null;
        return MaquinariaDTO.builder()
                .id_maquinaria(entity.getId_maquinaria())
                .patente_maquinaria(entity.getPatente_maquinaria())
                .nombre_maquinaria(entity.getNombre_maquinaria())
                .tipo_maquinaria(entity.getTipo_maquinaria())
                .precio_compra_maquinaria(entity.getPrecio_compra_maquinaria())
                .frecuencia_mantenimiento_maquinaria(entity.getFrecuencia_mantenimiento_maquinaria())
                .horometro_maquinaria(entity.getHorometro_maquinaria())
                .build();
    }

    @Override
    public Maquinaria fromDTO(MaquinariaDTO dto) {
        if(dto == null ) return null;
        return Maquinaria.builder()
                .id_maquinaria(dto.getId_maquinaria())
                .patente_maquinaria(dto.getPatente_maquinaria())
                .nombre_maquinaria(dto.getNombre_maquinaria())
                .tipo_maquinaria(dto.getTipo_maquinaria())
                .precio_compra_maquinaria(dto.getPrecio_compra_maquinaria())
                .frecuencia_mantenimiento_maquinaria(dto.getFrecuencia_mantenimiento_maquinaria())
                .horometro_maquinaria((dto.getHorometro_maquinaria()))
                .build();
    }
}
