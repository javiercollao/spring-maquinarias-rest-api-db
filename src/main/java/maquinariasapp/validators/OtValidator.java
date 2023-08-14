package maquinariasapp.validators;

import maquinariasapp.entity.Ot;
import maquinariasapp.exceptions.ValidateServiceException;

public class OtValidator {
    public static void validacionDeGuardado(Ot ot){
        if (ot.getDesc_ot() == null || ot.getDesc_ot().isEmpty()) {
            throw new ValidateServiceException("La descripción de la ot es requerida");
        }

        if (ot.getFecha_ot() == null || ot.getFecha_ot().isEmpty()) {
            throw new ValidateServiceException("La fecha de la ot es requerida");
        }

        if (ot.getProxima_fecha_ot() == null || ot.getProxima_fecha_ot().isEmpty()) {
            throw new ValidateServiceException("La proxima fecha de evaluación es requerida");
        }

        if (ot.getObservacion_ot() == null || ot.getObservacion_ot().isEmpty()) {
            throw new ValidateServiceException("La observación es requerida");
        }

        if (ot.getObservacion_ot().length() > 50){
            throw new ValidateServiceException("La observación debe ser más resumida");
        }

        if (ot.getClase_mantenimiento_ot() == null || ot.getClase_mantenimiento_ot().isEmpty()) {
            throw new ValidateServiceException("La clase de mantenimiento es requerida");
        }

        if (ot.getClase_mantenimiento_ot().length() > 50){
            throw new ValidateServiceException("La clase de mantenimiento excede de caracteres");
        }

    }
}
