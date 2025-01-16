package com.exercise;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 5);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(20000, 3);

        
        cuentaAhorros.consignar(5000);
        cuentaAhorros.retirar(2000);
        cuentaAhorros.generarExtractoMensual();
        System.out.println("Cuenta de Ahorros:");
        System.out.println(cuentaAhorros.imprimir());

        
        cuentaCorriente.retirar(25000);
        cuentaCorriente.consignar(10000);
        cuentaCorriente.generarExtractoMensual();
        System.out.println("\nCuenta Corriente:");
        System.out.println(cuentaCorriente.imprimir());
    }
}
