package modelo;

public class Cliente {
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + ", Correo: " + correo;
    }

    public String actualizarInformacion(String nuevoNombre, String nuevoCorreo) {
        this.nombre = nuevoNombre;
        this.correo = nuevoCorreo;
        return "Información actualizada: " + mostrarInformacion();
    }
}
