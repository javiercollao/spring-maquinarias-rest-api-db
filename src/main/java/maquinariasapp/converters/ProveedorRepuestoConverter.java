package maquinariasapp.converters;

import maquinariasapp.dtos.ProveedorRepuestoDTO;
import maquinariasapp.entity.ProveedorRepuesto;
import org.springframework.stereotype.Component;

@Component
public class ProveedorRepuestoConverter extends AbstractConverter<ProveedorRepuesto, ProveedorRepuestoDTO>{
    @Override
    public ProveedorRepuestoDTO fromEntity(ProveedorRepuesto entity) {
        if(entity == null ) return null;
        return ProveedorRepuestoDTO.builder()
                .id_prov_rep(entity.getId_prov_rep())
                .cantidad_repuesto(entity.getCantidad_repuesto())
                .build();
    }

    @Override
    public ProveedorRepuesto fromDTO(ProveedorRepuestoDTO dto) {
        if(dto == null ) return null;
        return ProveedorRepuesto.builder()
                .id_prov_rep(dto.getId_prov_rep())
                .cantidad_repuesto(dto.getCantidad_repuesto())
                .build();
    }
}
