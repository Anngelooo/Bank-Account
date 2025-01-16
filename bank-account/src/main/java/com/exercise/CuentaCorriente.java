package com.exercise;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            } else {
                sobregiro += (cantidad - saldo);
                saldo = 0;
            }
            numRetiros++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            if (sobregiro > 0) {
                if (cantidad >= sobregiro) {
                    saldo += (cantidad - sobregiro);
                    sobregiro = 0;
                } else {
                    sobregiro -= cantidad;
                }
            } else {
                saldo += cantidad;
            }
            numConsignaciones++;
        }
    }

    @Override
    public String imprimir() {
        return String.format("Saldo: %.2f, Comisión Mensual: %.2f, Transacciones: %d, Sobregiro: %.2f",
                saldo, comisionMensual, numConsignaciones + numRetiros, sobregiro);
    }
}
