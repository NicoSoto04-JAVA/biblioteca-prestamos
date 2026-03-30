package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public String registrarPrestamo(
            String codigoPrestamo,
            String codigoLibro,
            String nombreUsuario,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucion) {

        if (codigoPrestamo == null || codigoPrestamo.isBlank() ||
                codigoLibro == null     || codigoLibro.isBlank()    ||
                nombreUsuario == null   || nombreUsuario.isBlank()  ||
                fechaPrestamo == null   || fechaDevolucion == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        if (!codigoPrestamo.matches("[A-Z]{2}\\d{4}")) {
            return "Ingrese un código de préstamo válido";
        }

        if (!codigoLibro.matches("[a-zA-Z0-9]{5}")) {
            return "Ingrese un código de libro válido";
        }

        if (!nombreUsuario.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]{4,}")) {
            return "El nombre del usuario debe tener al menos cuatro caracteres alfabéticos";
        }

        if (fechaPrestamo.isAfter(LocalDate.now())) {
            return "Ingrese una fecha de préstamo válida";
        }

        if (!fechaDevolucion.isAfter(fechaPrestamo)) {
            return "La fecha de devolución debe ser posterior a la fecha de préstamo";
        }

        return "El préstamo ha sido registrado correctamente";
    }
}
