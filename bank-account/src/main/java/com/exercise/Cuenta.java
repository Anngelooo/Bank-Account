package com.exercise;

public class Cuenta {
protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    
    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
    }

    
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    
    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        }
    }

    
    public void calcularInteresMensual() {
        float interesMensual = saldo * (tasaAnual / 12 / 100);
        saldo += interesMensual;
    }

    
    public void generarExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    
    public String imprimir() {
        return String.format("Saldo: %.2f, Comisión Mensual: %.2f, Consignaciones: %d, Retiros: %d",
                saldo, comisionMensual, numConsignaciones, numRetiros);
    }
}
