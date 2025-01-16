package com.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuentaAhorrosTest {
@Test
    void testConsignarCuentaActiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 5);
        cuentaAhorros.consignar(5000);
        assertEquals(20000, cuentaAhorros.saldo);
    }

    @Test
    void testConsignarCuentaInactiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(8000, 5);
        cuentaAhorros.consignar(5000); // No debería permitir consignar si está inactiva
        assertEquals(8000, cuentaAhorros.saldo);
    }

    @Test
    void testRetirarCuentaActiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 5);
        cuentaAhorros.retirar(5000);
        assertEquals(10000, cuentaAhorros.saldo);
    }

    @Test
    void testRetirarCuentaInactiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(8000, 5);
        cuentaAhorros.retirar(5000); // No debería permitir retirar si está inactiva
        assertEquals(8000, cuentaAhorros.saldo);
    }

    @Test
    void testGenerarExtractoMensual() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 5);
        cuentaAhorros.retirar(5000);
        cuentaAhorros.generarExtractoMensual();
        assertEquals(10000 + 41.66, cuentaAhorros.saldo, 0.01); // Incluye interés mensual
    }
}
