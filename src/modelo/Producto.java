package modelo;

public class Producto implements IProducto {
    private String nombre;
    private String descripcion;

    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String verDetalles(Usuario usuario) {
        return "Producto: " + nombre + "\nDescripción: " + descripcion;
    }
}

