package maquinariasapp.service;

import maquinariasapp.dtos.MaquinariaDTO;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.repository.MaquinariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaquinariaService {

    @Autowired
    MaquinariaRepository maquinariaRepository;

    public List<Maquinaria> obtenerTodosLasMaquinarias(){
        return maquinariaRepository.findAll().stream().toList();
    }

    public Maquinaria obtenerMaquinariaPorId(Long id){ return  maquinariaRepository.findById(id).get(); }

    public Maquinaria crearNuevaMaquinaria(MaquinariaDTO maquinaria){
        Maquinaria nuevaMaquinaria = new Maquinaria();
        nuevaMaquinaria.setCod_maquinaria(maquinaria.getCod_maquinaria());
        nuevaMaquinaria.setNombre_maquinaria(maquinaria.getNombre_maquinaria());
        nuevaMaquinaria.setTipo_maquinaria(maquinaria.getTipo_maquinaria());
        nuevaMaquinaria.setFecha_ingreso_maquinaria(LocalDateTime.now());
        nuevaMaquinaria.setPrecio_compra_maquinaria(maquinaria.getPrecio_compra_maquinaria());
        nuevaMaquinaria.setFrecuencia_mantenimiento_maquinaria(maquinaria.getFrecuencia_mantenimiento_maquinaria());
        nuevaMaquinaria.setHorometro_maquinaria(maquinaria.getHorometro_maquinaria());
        return maquinariaRepository.save(nuevaMaquinaria);
    }

    public Maquinaria actualizarDatosMaquinaria(Long id, MaquinariaDTO maquinaria) throws RuntimeException{
        Maquinaria seleccionMaquinaria = maquinariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maquinaria not found for this id :: " + id));
        seleccionMaquinaria.setCod_maquinaria(maquinaria.getCod_maquinaria());
        seleccionMaquinaria.setNombre_maquinaria(maquinaria.getNombre_maquinaria());
        seleccionMaquinaria.setTipo_maquinaria(maquinaria.getTipo_maquinaria());
        seleccionMaquinaria.setPrecio_compra_maquinaria(maquinaria.getPrecio_compra_maquinaria());
        seleccionMaquinaria.setFrecuencia_mantenimiento_maquinaria(maquinaria.getFrecuencia_mantenimiento_maquinaria());
        seleccionMaquinaria.setHorometro_maquinaria(maquinaria.getHorometro_maquinaria());
        return maquinariaRepository.save(seleccionMaquinaria);
    }



}
