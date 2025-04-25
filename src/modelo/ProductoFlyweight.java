package modelo;

public class ProductoFlyweight {
    private String nombreProducto;
    private double precio;
    private Proveedor proveedor; // Flyweight compartido

    public ProductoFlyweight(String nombreProducto, double precio, String nombreProveedor, String contactoProveedor) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.proveedor = ProveedorFactory.obtenerProveedor(nombreProveedor, contactoProveedor);
    }

    public String mostrarProducto() {
        return "Producto: " + nombreProducto + ", Precio: $" + precio + "\n" + proveedor.mostrarInfo();
    }
}

