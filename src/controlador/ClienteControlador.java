package controlador;

import modelo.Cliente;

public class ClienteControlador {
    private Cliente cliente;

    public ClienteControlador(Cliente cliente) {
        this.cliente = cliente;
    }

    public String actualizarDatos(String nombre, String correo) {
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        return "Datos del cliente actualizados.";
    }

    public String mostrarDatos() {
        return "Nombre: " + cliente.getNombre() + "\nCorreo: " + cliente.getCorreo();
    }

    public String getNombre() {
        return cliente.getNombre();
    }

    public String getCorreo() {
        return cliente.getCorreo();
    }
}


