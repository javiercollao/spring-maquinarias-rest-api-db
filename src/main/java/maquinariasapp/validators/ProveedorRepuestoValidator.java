package maquinariasapp.validators;

import maquinariasapp.entity.ProveedorRepuesto;
import maquinariasapp.exceptions.ValidateServiceException;

public class ProveedorRepuestoValidator {
    public static void validacionDeGuardado(ProveedorRepuesto proveedorRepuesto){
        if (proveedorRepuesto.getCantidad_repuesto() == null) {
            throw new ValidateServiceException("La cantidad de repuestos es requerido");
        }
    }
}
