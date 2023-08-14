package maquinariasapp.converters;

import maquinariasapp.dtos.OtDTO;
import maquinariasapp.entity.Ot;
import org.springframework.stereotype.Component;

@Component
public class OtConverter extends AbstractConverter<Ot, OtDTO> {
    @Override
    public OtDTO fromEntity(Ot entity) {
        if(entity == null ) return null;
        return  OtDTO.builder()
                .id_ot(entity.getId_ot())
                .desc_ot(entity.getDesc_ot())
                .observacion_ot(entity.getObservacion_ot())
                .clase_mantenimiento_ot(entity.getClase_mantenimiento_ot())
                .fecha_ot(entity.getFecha_ot())
                .proxima_fecha_ot(entity.getProxima_fecha_ot())
                .build();
    }

    @Override
    public Ot fromDTO(OtDTO dto) {
        if(dto == null ) return null;
        return Ot.builder()
                .id_ot(dto.getId_ot())
                .desc_ot(dto.getDesc_ot())
                .observacion_ot(dto.getObservacion_ot())
                .clase_mantenimiento_ot(dto.getClase_mantenimiento_ot())
                .build();
    }
}
