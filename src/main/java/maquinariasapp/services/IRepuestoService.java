package maquinariasapp.services;

import maquinariasapp.entity.Repuesto;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IRepuestoService {
    public Repuesto crearNuevoRepuesto(Repuesto repuesto);
    public List<Repuesto> obtenerTodosLosRepuestos(Pageable page);
    public Repuesto obtenerRepuestoPorId(Long id);
    public Repuesto actualizarDatosDeRepuesto(Long id, Repuesto repuesto);
}
