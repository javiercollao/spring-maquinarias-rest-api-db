package maquinariasapp.validators;

import maquinariasapp.entity.Maquinaria;
import maquinariasapp.exceptions.ValidateServiceException;

public class MaquinariaValidator {
    public static void validacionDeGuardado(Maquinaria maquinaria) {
        if (maquinaria.getNombre_maquinaria() == null || maquinaria.getNombre_maquinaria().isEmpty()) {
            throw new ValidateServiceException("El nombre de la maquinaria es requerido");
        }

        if (maquinaria.getNombre_maquinaria().length() > 50){
            throw new ValidateServiceException("El nombre de la maquinaria es muy largo");
        }

        if (maquinaria.getPatente_maquinaria() == null || maquinaria.getPatente_maquinaria().isEmpty()) {
            throw new ValidateServiceException("La patenete de la maquinaria es requerido");
        }

        if (maquinaria.getPatente_maquinaria().length() > 30){
            throw new ValidateServiceException("La patente de la maquinaria no es válida");
        }

        if (maquinaria.getTipo_maquinaria() == null || maquinaria.getTipo_maquinaria().isEmpty()) {
            throw new ValidateServiceException("El tipo de  maquinaria es requerido");
        }

        if (maquinaria.getTipo_maquinaria().length() > 20){
            throw new ValidateServiceException("El tipo de maquinaria no es válida");
        }

 
        if (maquinaria.getPrecio_compra_maquinaria() == null || maquinaria.getPrecio_compra_maquinaria().isEmpty()) {
            throw new ValidateServiceException("El precio de compra es requerido");
        }

        if (maquinaria.getPrecio_compra_maquinaria().length() > 20){
            throw new ValidateServiceException("La cifra no es válida");
        }

        if (maquinaria.getFrecuencia_mantenimiento_maquinaria() == null || maquinaria.getFrecuencia_mantenimiento_maquinaria().isEmpty()) {
            throw new ValidateServiceException("La frecuencia de mantenimiento de la maquinaria es requerida");
        }

        if (maquinaria.getFrecuencia_mantenimiento_maquinaria().length() > 20){
            throw new ValidateServiceException("La frecuencia no es válida");
        }


        if (maquinaria.getHorometro_maquinaria() == null || maquinaria.getHorometro_maquinaria().isEmpty()) {
            throw new ValidateServiceException("El valor de horometro es requerido");
        }

        if (maquinaria.getHorometro_maquinaria().length() > 20){
            throw new ValidateServiceException("El valor no es válido");
        }

        if (maquinaria.getFecha_ingreso_maquinaria() == null) {
            throw new ValidateServiceException("La fecha de ingreso de la maquinaria es requerida");
        }

    }
}
