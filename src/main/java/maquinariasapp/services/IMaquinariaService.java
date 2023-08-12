package maquinariasapp.services;

import maquinariasapp.entity.Maquinaria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMaquinariaService {
    public Maquinaria crearNuevaMaquinaria(Maquinaria maquinaria);
    public List<Maquinaria> obtenerTodosLasMaquinarias(Pageable page);
    public Maquinaria obtenerMaquinariaPorId(Long maquinariaId);
    public Maquinaria actualizarMaquinaria(Long maquinariaId, Maquinaria maquinaria);

}
