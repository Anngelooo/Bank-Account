package com.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuentaTest {
@Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(10000, 5);
        cuenta.consignar(5000);
        assertEquals(15000, cuenta.saldo);
    }

    @Test
    void testRetirarExitoso() {
        Cuenta cuenta = new Cuenta(10000, 5);
        cuenta.retirar(5000);
        assertEquals(5000, cuenta.saldo);
    }

    @Test
    void testRetirarFallido() {
        Cuenta cuenta = new Cuenta(10000, 5);
        cuenta.retirar(15000); // No se puede retirar más del saldo
        assertEquals(10000, cuenta.saldo);
    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(10000, 12);
        cuenta.calcularInteresMensual();
        assertEquals(10100, cuenta.saldo, 0.01);
    }

    @Test
    void testGenerarExtractoMensual() {
        Cuenta cuenta = new Cuenta(10000, 12);
        cuenta.comisionMensual = 100;
        cuenta.generarExtractoMensual();
        assertEquals(9999.0 - 100 + 100, cuenta.saldo, 0.01);
    }
}
