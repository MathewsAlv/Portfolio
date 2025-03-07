package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private double saldo;
    Persona titular = new Persona();
    private String numeroCuenta;
    private static final ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    private static final Random random = new Random();

    
    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = generarNumeroCuenta();
        listaDeCuentasBancarias.add(this);
        
    }

    private String generarNumeroCuenta() {
        int numero = 100000 + random.nextInt(900000);
        return String.valueOf(numero);
    }


    public double getSaldo() {
        return saldo;
    }


    public Persona getTitular() {
        return titular;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void setTitular(Persona titular) {
        this.titular = titular;
    }


    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void depositar(double monto){
        this.saldo += monto;
        System.out.println("Se ha agregado $" + monto + " a su cuenta.");
    }

    public void retirar(double monto){
        if (this.saldo >= monto){
            this.saldo -= monto;
            System.out.println("Se ha retirado $" + monto + " de su cuenta.");
        } else{
            System.out.println("Fondos insuficientes.");
        }
        
    }

    public void despliegaInformacion(){
        titular.despliegaInformacion();
        System.out.println("Su saldo es: $" + saldo);
        System.out.println("Numero de cuenta " + numeroCuenta);
    }

    public static void imprimeInformacionDeTodasLasCuentas(){
        for (CuentaBancaria cuenta : listaDeCuentasBancarias){
            cuenta.despliegaInformacion();
            System.out.println("----------------");
        }
    }
}
