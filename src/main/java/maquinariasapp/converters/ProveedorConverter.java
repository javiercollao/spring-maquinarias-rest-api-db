package maquinariasapp.converters;

import maquinariasapp.dtos.ProveedorDTO;
import maquinariasapp.entity.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorConverter extends AbstractConverter<Proveedor, ProveedorDTO>{
    @Override
    public ProveedorDTO fromEntity(Proveedor entity) {
        if(entity == null ) return null;
        return ProveedorDTO.builder()
                .id_proveedor(entity.getId_proveedor())
                .nombre_proveedor(entity.getNombre_proveedor())
                .build();
    }

    @Override
    public Proveedor fromDTO(ProveedorDTO dto) {
        if(dto == null ) return null;
        return Proveedor.builder()
                .id_proveedor(dto.getId_proveedor())
                .nombre_proveedor(dto.getNombre_proveedor())
                .build();
    }
}
