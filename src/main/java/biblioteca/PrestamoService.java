package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public String registrarPrestamo(
            String codigoPrestamo,
            String codigoLibro,
            String nombreUsuario,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucion) {

        if (camposVacios(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion))
            return "Debe ingresar todos los datos requeridos";

        if (!esCodigoPrestamoValido(codigoPrestamo))
            return "Ingrese un código de préstamo válido";

        if (!esCodigoLibroValido(codigoLibro))
            return "Ingrese un código de libro válido";

        if (!esNombreValido(nombreUsuario))
            return "El nombre del usuario debe tener al menos cuatro caracteres alfabéticos";

        if (!esFechaPrestamoValida(fechaPrestamo))
            return "Ingrese una fecha de préstamo válida";

        if (!esFechaDevolucionValida(fechaPrestamo, fechaDevolucion))
            return "La fecha de devolución debe ser posterior a la fecha de préstamo";

        return "El préstamo ha sido registrado correctamente";
    }

    private boolean camposVacios(String cp, String cl, String nu,
                                 LocalDate fp, LocalDate fd) {
        return cp == null || cp.isBlank() ||
                cl == null || cl.isBlank() ||
                nu == null || nu.isBlank() ||
                fp == null || fd == null;
    }

    private boolean esCodigoPrestamoValido(String codigo) {
        return codigo.matches("[A-Z]{2}\\d{4}");
    }

    private boolean esCodigoLibroValido(String codigo) {
        return codigo.matches("[a-zA-Z0-9]{5}");
    }

    private boolean esNombreValido(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]{4,}");
    }

    private boolean esFechaPrestamoValida(LocalDate fechaPrestamo) {
        return !fechaPrestamo.isAfter(LocalDate.now());
    }

    private boolean esFechaDevolucionValida(LocalDate prestamo, LocalDate devolucion) {
        return devolucion.isAfter(prestamo);
    }
}