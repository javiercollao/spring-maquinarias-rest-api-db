package maquinariasapp.services;

import maquinariasapp.entity.Operario;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOperarioService {
    public List<Operario> obtenerOperariosRegistrados(Pageable page);
    public Operario obtenerOperarioPorId(Long idOperario);
    public Operario crearNuevoOperario(Operario operario);
    public Operario actualizarDatosOperario(Long idOperario, Operario operario);
}
