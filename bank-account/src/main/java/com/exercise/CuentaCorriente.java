package com.exercise;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
    }

    public float getSobregiro() {
        return sobregiro;
        
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
        
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            } else {
                setSobregiro(getSobregiro() + (cantidad - saldo));
                saldo = 0;
            }
            numRetiros++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            if (getSobregiro() > 0) {
                if (cantidad >= getSobregiro()) {
                    saldo += (cantidad - getSobregiro());
                    setSobregiro(0);
                } else {
                    setSobregiro(getSobregiro() - cantidad);
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
                saldo, comisionMensual, numConsignaciones + numRetiros, getSobregiro());
    }
}
