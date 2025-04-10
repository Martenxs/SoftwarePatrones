package modelo;

import modelo.Cliente;
import modelo.FormaPago;
import modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ClienteFacade {
    private Cliente cliente;
    private List<FormaPago> formasPago;
    private List<Pedido> historialPedidos;

    public ClienteFacade(Cliente cliente, List<FormaPago> formasPago, List<Pedido> historialPedidos) {
        this.cliente = cliente;
        this.formasPago = formasPago;
        this.historialPedidos = historialPedidos;
    }

    public String actualizarCliente(String nombre, String correo) {
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        return "Cliente actualizado: " + nombre + ", " + correo;
    }

    public String mostrarCliente() {
        return "Cliente: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo();
    }

    public String realizarPedido(String descripcion) {
        Pedido nuevoPedido = new Pedido(descripcion);
        historialPedidos.add(nuevoPedido);
        return "Pedido realizado: " + descripcion;
    }

    public String mostrarHistorialPedido() {
        if (historialPedidos.isEmpty()) return "No hay pedidos registrados.";
        StringBuilder sb = new StringBuilder("Historial de pedidos:\n");
        for (Pedido p : historialPedidos) {
            sb.append("- ").append(p.getDescripcion()).append("\n");
        }
        return sb.toString();
    }

    public String agregarFormaPago(String metodo) {
        formasPago.add(new FormaPago(metodo));
        return "Forma de pago agregada: " + metodo;
    }

    public String mostrarFormasPago() {
        if (formasPago.isEmpty()) return "No hay formas de pago registradas.";
        StringBuilder sb = new StringBuilder("Formas de pago:\n");
        for (FormaPago f : formasPago) {
            sb.append("- ").append(f.getMetodo()).append(" (Activo: ").append(f.isActivo()).append(")\n");
        }
        return sb.toString();
    }

    public String bloquearPago(String metodo) {
        for (FormaPago f : formasPago) {
            if (f.getMetodo().equalsIgnoreCase(metodo)) {
                f.setActivo(false);
                return "Forma de pago bloqueada: " + metodo;
            }
        }
        return "Método no encontrado: " + metodo;
    }

    public String activarPago(String metodo) {
        for (FormaPago f : formasPago) {
            if (f.getMetodo().equalsIgnoreCase(metodo)) {
                f.setActivo(true);
                return "Forma de pago activada: " + metodo;
            }
        }
        return "Método no encontrado: " + metodo;
    }

    public String obtenerDatosCliente() {
        return mostrarCliente() + "\n" + mostrarFormasPago();
    }
}

