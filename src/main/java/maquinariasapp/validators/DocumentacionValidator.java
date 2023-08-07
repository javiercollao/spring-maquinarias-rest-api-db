package maquinariasapp.validators;

import maquinariasapp.entity.Documentacion;

public class DocumentacionValidator {
    public static void validacionDeGuardado(Documentacion documentacion) {

        if (documentacion.getNombre_documentacion() == null || documentacion.getNombre_documentacion().isEmpty()) {
            throw new RuntimeException("El nombre de la documentación es requerido");
        }

        if (documentacion.getNombre_documentacion().length() > 70){
            throw new RuntimeException("El nombre de la documentación es muy largo");
        }

        if (documentacion.getDesc_documentacion() == null || documentacion.getDesc_documentacion().isEmpty()) {
            throw new RuntimeException("La descripción de la documentación que se quiere añadir es requerida");
        }

        if (documentacion.getDesc_documentacion().length() > 200){
            throw new RuntimeException("La descripción de la documentación es muy larga");
        }

        if (documentacion.getArchivo_documentacion() == null || documentacion.getArchivo_documentacion() .isEmpty()) {
            throw new RuntimeException("El archivo de la documentación es requerido");
        }

    }
}
