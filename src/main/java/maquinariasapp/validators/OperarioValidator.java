package operariosapp.validators;

import maquinariasapp.entity.Operario;
import maquinariasapp.exceptions.ValidateServiceException;

import java.util.regex.Pattern;

public class OperarioValidator {
    public static void validacionDeGuardado(Operario operario){
         if (operario.getCorreo_operario() == null || operario.getCorreo_operario().isEmpty()) {
            throw new ValidateServiceException("El correo de operario es requerido");
        }

        if (!this.validateEmail(operario.getCorreo_operario)){
            throw new ValidateServiceException("El correo ingresado no es válido");
        }

        if (operario.getNombre_operario() == null || operario.getNombre_operario().isEmpty()) {
            throw new ValidateServiceException("El nombre de la operario es requerido");
        }

        if (operario.getNombre_operario().length() > 20){
            throw new ValidateServiceException("El nombre de operario es muy largo");
        }

        if (operario.getApellido_operario() == null || operario.getApellido_operario().isEmpty()) {
            throw new ValidateServiceException("El apellido del operario es requerido");
        }

        if (operario.getApellido_operario().length() > 30){
            throw new ValidateServiceException("El apellido de operario es muy largo");
        }

        if (operario.getCargo_operario() == null || operario.getCargo_operario().isEmpty()) {
            throw new ValidateServiceException("El cargo de operario es requerido");
        }

        if (operario.getCargo_operario().length() > 50){
            throw new ValidateServiceException("El cargo de operario excede de caracteres");
        }

    }

    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
