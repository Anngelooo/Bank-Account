package com.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
@Test
    void testRetirarSinSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);
        cuentaCorriente.retirar(15000);
        assertEquals(5000, cuentaCorriente.saldo);
        assertEquals(0, cuentaCorriente.getSobregiro());
    }

    @Test
    void testRetirarConSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);
        cuentaCorriente.retirar(25000);
        assertEquals(0, cuentaCorriente.saldo);
        assertEquals(5000, cuentaCorriente.getSobregiro());
    }

    @Test
    void testConsignarReducirSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);
        cuentaCorriente.retirar(25000);
        cuentaCorriente.consignar(3000); // Reduce el sobregiro
        assertEquals(0, cuentaCorriente.saldo);
        assertEquals(2000, cuentaCorriente.getSobregiro());
    }

    @Test
    void testConsignarCubrirSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);
        cuentaCorriente.retirar(25000);
        cuentaCorriente.consignar(6000); // Cubre sobregiro y deja saldo positivo
        assertEquals(1000, cuentaCorriente.saldo);
        assertEquals(0, cuentaCorriente.getSobregiro());
    }

    @Test
    void testGenerarExtractoMensual() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);
        cuentaCorriente.retirar(15000);
        cuentaCorriente.generarExtractoMensual();
        assertEquals(5000 + 12.5, cuentaCorriente.saldo, 0.01); // Incluye interés mensual
    }
}
