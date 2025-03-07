package clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
    public String marca;
    public int memoriaRam;
    public int numeroSerie;


    public ComputadoraPortatil(String nombre, double precio, int cantidadDisponible, String marca, int memoriaRam,
            int numeroSerie) {
        super(nombre, precio, cantidadDisponible);
        this.marca = marca;
        this.memoriaRam = memoriaRam;
        this.numeroSerie = numeroSerie;
    }
    public ComputadoraPortatil(String nombre, double precio, String marca, int memoriaRam, int numeroSerie) {
        super(nombre, precio);
        this.marca = marca;
        this.memoriaRam = memoriaRam;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("Marca: " + marca);
        System.out.println("Memoria Ram disponible: " + memoriaRam + "GB");
        System.out.println("Numero de serie: " + numeroSerie);
        System.out.println("Cantidad disponible: " + super.getCantidadDisponible());
        System.out.println("----------");
    }

    
}
