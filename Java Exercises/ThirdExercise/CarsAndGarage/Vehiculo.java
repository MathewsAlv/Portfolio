package POO.actividades.carygarage;

public class Vehiculo {
    public String marca;
    public String modelo;
    public int ano;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void despliegaInformacion(){
        System.out.println("La marca del vehiculo es: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año " + this.ano);
    }

    
}
