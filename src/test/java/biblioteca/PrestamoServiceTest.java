package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrestamoServiceTest {

    private PrestamoService service;

    @BeforeEach
    void setUp() {
        service = new PrestamoService();
    }

    @Test
    void testCodigoPrestamo_invalido() {
        String resultado = service.registrarPrestamo(
                "PR123",
                "LIB01",
                "Carlos",
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
        assertEquals("Ingrese un código de préstamo válido", resultado);
    }

    @Test
    void testCodigoLibro_invalido() {
        String resultado = service.registrarPrestamo(
                "PR1234",
                "LB01",
                "Pedro",
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
        assertEquals("Ingrese un código de libro válido", resultado);
    }

    @Test
    void testNombreUsuario_invalido() {
        String resultado = service.registrarPrestamo(
                "PR1234",
                "LIB01",
                "Ana",
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
        assertEquals("El nombre del usuario debe tener al menos cuatro caracteres alfabéticos", resultado);
    }

    @Test
    void testFechaPrestamo_invalida() {
        String resultado = service.registrarPrestamo(
                "PR1234",
                "LIB01",
                "Sofia",
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(8)
        );
        assertEquals("Ingrese una fecha de préstamo válida", resultado);
    }

    @Test
    void testFechaDevolucion_invalida() {
        String resultado = service.registrarPrestamo(
                "PR1234",
                "LIB01",
                "Lucas",
                LocalDate.now(),
                LocalDate.now()
        );
        assertEquals("La fecha de devolución debe ser posterior a la fecha de préstamo", resultado);
    }

    @Test
    void testRegistro_exitoso() {
        String resultado = service.registrarPrestamo(
                "PR1234",
                "LIB01",
                "Diana",
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
        assertEquals("El préstamo ha sido registrado correctamente", resultado);
    }
}