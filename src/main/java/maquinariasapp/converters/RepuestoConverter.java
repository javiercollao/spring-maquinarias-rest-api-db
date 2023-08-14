package maquinariasapp.converters;

import maquinariasapp.dtos.RepuestoDTO;
import maquinariasapp.entity.Repuesto;
import org.springframework.stereotype.Component;

@Component
public class RepuestoConverter extends AbstractConverter<Repuesto, RepuestoDTO>{
    @Override
    public RepuestoDTO fromEntity(Repuesto entity) {
        if(entity == null ) return null;
        return RepuestoDTO.builder()
                .id_repuesto(entity.getId_repuesto())
                .nombre_repuesto(entity.getNombre_repuesto())
                .desc_repuesto(entity.getDesc_repuesto())
                .build();
    }

    @Override
    public Repuesto fromDTO(RepuestoDTO dto) {
        if(dto == null ) return null;
        return Repuesto.builder()
                .id_repuesto(dto.getId_repuesto())
                .nombre_repuesto(dto.getNombre_repuesto())
                .desc_repuesto(dto.getDesc_repuesto())
                .build();
    }
}
