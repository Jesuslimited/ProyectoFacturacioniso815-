package com.factura.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cedulaValidator")
public class CedulaValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cedula = value.toString();
        if (!isValidCedula(cedula)) {
            FacesMessage msg = new FacesMessage("Cédula no válida", "Formato de cédula no válido o cédula dominicana incorrecta.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    private boolean isValidCedula(String cedula) {
        // Validar longitud y formato básico
        if (cedula == null || !cedula.matches("\\d{3}-\\d{7}-\\d{1}")) {
            return false;
        }
        
        // Eliminar guiones y espacios si los hay
        cedula = cedula.replaceAll("\\s|-", "");
        
        // Verificar que la cédula tenga 11 caracteres después de eliminar guiones y espacios
        if (cedula.length() != 11) {
            return false;
        }
        
        // Obtener el dígito verificador
        int digitoVerificador = Character.getNumericValue(cedula.charAt(10));
        
        // Calcular dígito verificador esperado
        int suma = 0;
        int factor = 1;
        for (int i = 0; i < 10; i++) {
            int num = Character.getNumericValue(cedula.charAt(i));
            int resultado = num * factor;
            if (resultado > 9) {
                resultado -= 9;
            }
            suma += resultado;
            factor = factor == 1 ? 2 : 1;
        }
        
        int residuo = suma % 10;
        int digitoEsperado = residuo == 0 ? 0 : 10 - residuo;
        
        return digitoEsperado == digitoVerificador;
    }
}
