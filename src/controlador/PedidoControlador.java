package controlador;

import java.util.ArrayList;
import java.util.List;

public class PedidoControlador {
    private List<String> pedidos = new ArrayList<>();

    public String realizarPedido(String descripcion) {
        pedidos.add(descripcion);
        return "Pedido realizado: " + descripcion;
    }

    public String mostrarHistorial() {
        if (pedidos.isEmpty()) return "No hay pedidos registrados.";
        StringBuilder sb = new StringBuilder("Historial de pedidos:\n");
        for (String p : pedidos) sb.append("- ").append(p).append("\n");
        return sb.toString();
    }
}
