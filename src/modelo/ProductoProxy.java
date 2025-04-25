package modelo;

public class ProductoProxy implements IProducto {
    private Producto productoReal;
    private final int nivelRequerido;

    public ProductoProxy(String nombre, String descripcion, int nivelRequerido) {
        this.productoReal = new Producto(nombre, descripcion);
        this.nivelRequerido = nivelRequerido;
    }

    @Override
    public String verDetalles(Usuario usuario) {
        if (usuario.getNivelAcceso() >= nivelRequerido) {
            return productoReal.verDetalles(usuario);
        } else {
            return "Acceso denegado para el usuario: " + usuario.getNombre() +
                    ". Nivel requerido: " + nivelRequerido +
                    ", tu nivel: " + usuario.getNivelAcceso();
        }
    }
}

