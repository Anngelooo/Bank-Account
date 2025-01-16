package com.exercise;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void generarExtractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.generarExtractoMensual();
        verificarEstadoCuenta();
    }

    private void verificarEstadoCuenta() {
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return String.format("Saldo: %.2f, Comisión Mensual: %.2f, Transacciones: %d, Activa: %b",
                saldo, comisionMensual, numConsignaciones + numRetiros, activa);
    }
}
