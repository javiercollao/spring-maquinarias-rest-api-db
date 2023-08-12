package maquinariasapp.services;

import maquinariasapp.entity.Operario;

import java.util.List;

public interface IOperarioService {
    public List<Operario> obtenerOperariosRegistrados();
    public Operario obtenerOperarioPorId(Long idOperario);
    public Operario crearNuevoOperario(Operario operario);
    public Operario actualizarDatosOperario(Long idOperario, Operario operario);
}
