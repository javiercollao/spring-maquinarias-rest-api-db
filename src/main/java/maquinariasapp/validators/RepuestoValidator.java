package maquinariasapp.validators;

import maquinariasapp.entity.Repuesto;
import maquinariasapp.exceptions.ValidateServiceException;

public class RepuestoValidator {
    public static void validacionDeGuardado(Repuesto repuesto){
        if (repuesto.getDesc_repuesto() == null || repuesto.getDesc_repuesto().isEmpty()) {
            throw new ValidateServiceException("La descripción del repuesto es requerida");
        }

        if (repuesto.getNombre_repuesto() == null || repuesto.getNombre_repuesto().isEmpty()) {
            throw new ValidateServiceException("El nombre del repuesto es requerido");
        }

        if (repuesto.getNombre_repuesto().length() > 70){
            throw new ValidateServiceException("El nombre del repuesto es muy largo");
        }
    }
}
