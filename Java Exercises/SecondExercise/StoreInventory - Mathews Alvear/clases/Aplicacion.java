package clases;

public class Aplicacion {
    public static void main(String[] args) {
        TiendaElectronica tienda = new TiendaElectronica();

        Televisor producto1 = new Televisor("Crystal UHD", 200.99, 10, 20, "curva");
        ComputadoraPortatil producto2 = new ComputadoraPortatil("Legion", 300, 5, "Lenovo", 16, 98128);

        System.out.println("----------");

        tienda.addInventory(producto1);
        tienda.addInventory(producto2);

        System.out.println("----------");

        tienda.showDisponible();

        System.out.println("----------");

        tienda.venta("Crystal UHD", 2);
        System.out.println("----------");
        tienda.venta("Legion", 3);
        System.out.println("----------");

        tienda.showDisponible();
    }
}
