package maquinariasapp.validators;

import maquinariasapp.entity.Proveedor;
import maquinariasapp.exceptions.ValidateServiceException;

public class ProveedorValidator {
    public static void validacionDeGuardado(Proveedor proveedor){
        if (proveedor.getNombre_proveedor() == null || proveedor.getNombre_proveedor().isEmpty()) {
            throw new ValidateServiceException("El nombre del proveedor es requerido");
        }

        if (proveedor.getNombre_proveedor().length() > 50){
            throw new ValidateServiceException("El nombre del proveedor es muy largo");
        }
    }
}
