package clases;

public class Televisor extends ProductoElectrodomestico {
    public double tamañoPantalla;
    public String tipoPantalla;


    public Televisor(String nombre, double precio, int cantidadDisponible, double tamañoPantalla, String tipoPantalla) {
        super(nombre, precio, cantidadDisponible);
        this.tamañoPantalla = tamañoPantalla;
        this.tipoPantalla = tipoPantalla;
    }
    public Televisor(String nombre, double precio, double tamañoPantalla, String tipoPantalla) {
        super(nombre, precio);
        this.tamañoPantalla = tamañoPantalla;
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Tamaño de pantalla: " + tamañoPantalla + "'");
        System.out.println("Tipo de pantalla: " + tipoPantalla);
        System.out.println("Cantidad disponible: " + super.getCantidadDisponible());
        System.out.println("----------");
    }



}
