package maquinariasapp.services;

import maquinariasapp.entity.Ot;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOtService {
    public List<Ot> obtenerTodasLasOt(Pageable page);
    public Ot obtenerOtPorId(Long otId);
    public List<Ot> obtenerOtsPorMaquinaria(Long maquinariaId);
    public Ot obtenerUltimaOtDeMaquinaria(Long maquinariaId);
    public Ot actualizarDatosDeOt(Long maquinariaId, Ot ot);

}
