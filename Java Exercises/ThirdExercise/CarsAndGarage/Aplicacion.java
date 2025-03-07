package POO.actividades.carygarage;

public class Aplicacion {
    public static void main(String[] args) {
        Vehiculo auto1 = new Vehiculo("Chevrolet", "Sail", 2024);
        Vehiculo auto2 = new Vehiculo("BMW", "M8 Coupé", 2022);
        Vehiculo auto3 = new Vehiculo("Audi", "A1 Sportback", 2023);

        Garage garage1 = new Garage(2);

        garage1.agregarVehiculo(auto3);
        garage1.agregarVehiculo(auto2);

        garage1.mostrarVehiculos();

        garage1.agregarVehiculo(auto1);

    }
}
