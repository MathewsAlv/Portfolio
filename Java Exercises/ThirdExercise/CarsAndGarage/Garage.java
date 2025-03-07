package POO.actividades.carygarage;

import java.util.ArrayList;

public class Garage {
    public ArrayList<Vehiculo> vehiculos;
    public int capacidadMaxima;
    
    public Garage() {
    }

    public Garage(int capacidadMaxima) {
        this.vehiculos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        if(vehiculos.size() < capacidadMaxima){
            vehiculos.add(vehiculo);
            System.out.println(vehiculo + " se ha agregado al garaje.");
        } else {
            System.out.println("No hay espacio en el garaje.");
        }
    }

    public void mostrarVehiculos(){
        if (vehiculos.isEmpty()) {
            System.out.println("El garaje está vacío.");
        } else {
            System.out.println("Vehículos en el garaje:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
        }
    }
    
}
