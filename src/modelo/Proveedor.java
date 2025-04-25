package modelo;

public class Proveedor {
    private String nombre;
    private String contacto;

    public Proveedor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String mostrarInfo() {
        return "Proveedor: " + nombre + ", Contacto: " + contacto;
    }
}
