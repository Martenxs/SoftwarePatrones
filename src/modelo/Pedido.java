package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<String> historial = new ArrayList<>();

    public String mostrarHistorial() {
        if (historial.isEmpty()) return "No hay pedidos aún.";
        return "Historial: " + String.join(", ", historial);
    }

    public String realizarPedido(String producto) {
        historial.add(producto);
        return "Pedido realizado: " + producto;
    }
}

