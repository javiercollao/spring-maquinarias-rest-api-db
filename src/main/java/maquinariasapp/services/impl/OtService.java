package maquinariasapp.services.impl;

import lombok.extern.slf4j.Slf4j;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.entity.Operario;
import maquinariasapp.entity.Ot;
import maquinariasapp.exceptions.GeneralServiceException;
import maquinariasapp.exceptions.NoDataFoundException;
import maquinariasapp.exceptions.ValidateServiceException;
import maquinariasapp.repository.MaquinariaRepository;
import maquinariasapp.repository.OperarioRepository;
import maquinariasapp.repository.OtRepository;
import maquinariasapp.services.IOtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Slf4j
@Service
public class OtService implements IOtService {
    @Autowired
    private OtRepository otRepository;

    @Autowired
    private MaquinariaRepository maquinariaRepository;

    @Autowired
    private OperarioRepository operarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ot> obtenerTodasLasOt(Pageable page) {
        try{
            return otRepository.findAll(page).toList();
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Ot obtenerOtPorId(Long otId) {
        try{
            Ot resultado = otRepository.findById(otId)
                 .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            return resultado;
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Ot crearNuevaOt(Long operarioId, Long maquinariaId, Ot ot) {
        try{
            Maquinaria maquinariaResultado = maquinariaRepository.findById(maquinariaId)
                 .orElseThrow(()-> new NoDataFoundException("No existe el registro de maquinaria con ese ID."));
            Operario operarioResultado = operarioRepository.findById(operarioId)
                 .orElseThrow(()-> new NoDataFoundException("No existe el registro de operario con ese ID."));
            Ot registro = new Ot();
            registro.setDesc_ot(ot.getDesc_ot());
            registro.setFecha_ot(LocalDateTime.now());
            registro.setProxima_fecha_ot(LocalDateTime.now().plusWeeks(1));
            registro.setObservacion_ot(ot.getObservacion_ot());
            registro.setClase_mantenimiento_ot(ot.getClase_mantenimiento_ot());
            registro.setOperario(operarioResultado);
            registro.setMaquinaria(maquinariaResultado);
            return otRepository.save(registro);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ot> obtenerOtsPorMaquinaria(Long maquinariaId) {
        try{
            Maquinaria maquinariaResultado = maquinariaRepository.findById(maquinariaId)
                 .orElseThrow(()-> new NoDataFoundException("No existe el registro de maquinaria con ese ID."));
            List<Ot> all = otRepository.findAll();
            List<Ot> resultado = all.stream().filter(m -> Objects.equals(m.getMaquinaria(),maquinariaResultado)).toList();
            return resultado;
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Ot obtenerUltimaOtDeMaquinaria(Long maquinariaId) {
        try{
            Maquinaria maquinariaResultado = maquinariaRepository.findById(maquinariaId)
                    .orElseThrow(()-> new NoDataFoundException("No existe el registro de maquinaria con ese ID."));
            List<Ot> all = otRepository.findAll();
            List<Ot> resultado = all.stream().filter(m -> Objects.equals(m.getMaquinaria(),maquinariaResultado)).toList();

            Optional<Ot> ultimoOt = resultado.stream()
                    .max(Comparator.comparing(Ot::getFecha_ot));

            if (ultimoOt.isPresent()) {
                Ot elementoMasReciente = ultimoOt.get();
                return elementoMasReciente;
            }
            return null;
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Ot actualizarDatosDeOt(Long otId, Ot ot) {
        try{
            Ot otResultado = otRepository.findById(otId)
                 .orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID."));
            otResultado.setDesc_ot(ot.getDesc_ot());
            otResultado.setFecha_ot(ot.getFecha_ot());
            otResultado.setProxima_fecha_ot(ot.getProxima_fecha_ot());
            otResultado.setObservacion_ot(ot.getObservacion_ot());
            otResultado.setClase_mantenimiento_ot(ot.getClase_mantenimiento_ot());
            return otRepository.save(otResultado);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
}
