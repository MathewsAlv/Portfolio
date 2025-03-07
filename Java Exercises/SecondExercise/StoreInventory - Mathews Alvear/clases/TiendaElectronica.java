package clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private final ArrayList<ProductoElectrodomestico> listaDeProductos;

    public TiendaElectronica(){
        this.listaDeProductos = new ArrayList<>();
    }


    public void addInventory(ProductoElectrodomestico producto){
        listaDeProductos.add(producto);
        System.out.println(producto + " se ha agregado.");
    }

    public void showDisponible(){
        for (ProductoElectrodomestico producto : listaDeProductos) {
            producto.mostrarInformacion();
            System.out.println(producto);
            System.out.println("----------");
        }
    }

    public ProductoElectrodomestico searchByName(String nombre){
        for (ProductoElectrodomestico producto : listaDeProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void venta(String nombreProducto, int cantidad){
        ProductoElectrodomestico producto = searchByName(nombreProducto);
        if (producto != null) {
            if (producto.getCantidadDisponible() >= cantidad) {
                producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
                System.out.println("Venta realizada. Cantidad restante de " + nombreProducto + ": " + producto.getCantidadDisponible());
            } else {
                System.out.println("Producto agotado");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
