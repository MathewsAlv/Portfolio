package clases;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Felipes", 27);
        Persona persona2 = new Persona("Pedros", 28);
        Persona persona3 = new Persona("Heribertus", 25);

        System.out.println("----------------");

        CuentaBancaria cuenta1 = new CuentaBancaria(250000, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(500000, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(125000, persona3);

        System.out.println("----------------");
        cuenta1.depositar(50000);
        System.out.println("----------------");
        cuenta1.retirar(100000);
        System.out.println("----------------");

        cuenta2.depositar(15000);
        System.out.println("----------------");
        cuenta2.retirar(90000);
        System.out.println("----------------");
        
        cuenta3.depositar(5000);
        System.out.println("----------------");
        cuenta3.retirar(120000);


        System.out.println("----------------");
/* 
        cuenta1.despliegaInformacion();
        System.out.println("----------------");
        cuenta2.despliegaInformacion();
        System.out.println("----------------");
        cuenta3.despliegaInformacion(); */

        System.out.println("----------------");

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}
