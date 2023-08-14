package maquinariasapp.converters;

import maquinariasapp.dtos.OperarioDTO;
import maquinariasapp.entity.Operario;
import org.springframework.stereotype.Component;

@Component
public class OperarioConverter extends AbstractConverter <Operario, OperarioDTO> {
    @Override
    public OperarioDTO fromEntity(Operario entity) {
        if(entity == null ) return null;
        return OperarioDTO.builder()
                .id_operario(entity.getId_operario())
                .nombre_operario(entity.getNombre_operario())
                .apellido_operario(entity.getApellido_operario())
                .correo_operario(entity.getCorreo_operario())
                .cargo_operario(entity.getCargo_operario())
                .build();
    }

    @Override
    public Operario fromDTO(OperarioDTO dto) {
        if(dto == null ) return null;
        return Operario.builder()
                .id_operario(dto.getId_operario())
                .nombre_operario(dto.getNombre_operario())
                .apellido_operario(dto.getApellido_operario())
                .correo_operario(dto.getCorreo_operario())
                .cargo_operario(dto.getCargo_operario())
                .build();
    }
}
