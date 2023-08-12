package maquinariasapp.service.impl;

import maquinariasapp.entity.Maquinaria;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.repository.MaquinariaRepository;
import maquinariasapp.services.IMaquinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaquinariaService implements IMaquinariaService {

    @Autowired
    MaquinariaRepository maquinariaRepository;

    @Override
    public Maquinaria crearNuevaMaquinaria(Maquinaria maquinaria){
       try {
           Maquinaria nuevaMaquinaria = new Maquinaria();
           nuevaMaquinaria.setPatente_maquinaria(maquinaria.getPatente_maquinaria());
           nuevaMaquinaria.setNombre_maquinaria(maquinaria.getNombre_maquinaria());
           nuevaMaquinaria.setTipo_maquinaria(maquinaria.getTipo_maquinaria());
           nuevaMaquinaria.setFecha_ingreso_maquinaria(LocalDateTime.now());
           nuevaMaquinaria.setPrecio_compra_maquinaria(maquinaria.getPrecio_compra_maquinaria());
           nuevaMaquinaria.setFrecuencia_mantenimiento_maquinaria(maquinaria.getFrecuencia_mantenimiento_maquinaria());
           nuevaMaquinaria.setHorometro_maquinaria(maquinaria.getHorometro_maquinaria());
           return maquinariaRepository.save(nuevaMaquinaria);
       } catch (){
           return null;
       }
    }

    @Override
    public List<Maquinaria> obtenerTodosLasMaquinarias(Pageable page) {
        try{
            return maquinariaRepository.findAll(page).toList();
        } catch (){
            return null;
        }
    }


    @Override
    public Maquinaria obtenerMaquinariaPorId(Long maquinariaId){
       try{
           Maquinaria maquinaria = maquinariaRepository.findById(maquinariaId)
                   .orElseThrow(()-> new NoDataFoundException("No existe una maquinaria con ese ID."));
           return maquinaria;
       } catch (){
           return null;
       }
    }


    @Override
    public Maquinaria actualizarMaquinaria(Long maquinariaId, Maquinaria maquinaria) {
        try {
            Maquinaria registro = maquinariaRepository.findById(maquinariaId)
                    .orElseThrow(()-> new NoDataFoundException("No existe una maquinaria con ese ID."));
            registro.setPatente_maquinaria(maquinaria.getPatente_maquinaria());
            registro.setNombre_maquinaria(maquinaria.getNombre_maquinaria());
            registro.setTipo_maquinaria(maquinaria.getTipo_maquinaria());
            registro.setFecha_ingreso_maquinaria(LocalDateTime.now());
            registro.setPrecio_compra_maquinaria(maquinaria.getPrecio_compra_maquinaria());
            registro.setFrecuencia_mantenimiento_maquinaria(maquinaria.getFrecuencia_mantenimiento_maquinaria());
            registro.setHorometro_maquinaria(maquinaria.getHorometro_maquinaria());
            return maquinariaRepository.save(registro);
        } catch () {
            return null;
        }
    }

}
