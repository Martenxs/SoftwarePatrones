package controlador;

import modelo.FormaPago;
import java.util.ArrayList;
import java.util.List;

public class PagoControlador {
    private List<FormaPago> metodos = new ArrayList<>();

    public String agregarMetodo(String metodo) {
        metodos.add(new FormaPago(metodo));
        return "Método de pago agregado: " + metodo;
    }

    public String mostrarMetodos() {
        if (metodos.isEmpty()) return "No hay métodos de pago registrados.";
        StringBuilder sb = new StringBuilder("Métodos de pago:\n");
        for (FormaPago f : metodos) sb.append("- ").append(f).append("\n");
        return sb.toString();
    }

    public String bloquearMetodo(String metodo) {
        for (FormaPago f : metodos) {
            if (f.getMetodo().equalsIgnoreCase(metodo)) {
                f.setActivo(false);
                return "Método bloqueado: " + metodo;
            }
        }
        return "Método no encontrado.";
    }

    public String activarMetodo(String metodo) {
        for (FormaPago f : metodos) {
            if (f.getMetodo().equalsIgnoreCase(metodo)) {
                f.setActivo(true);
                return "Método activado: " + metodo;
            }
        }
        return "Método no encontrado.";
    }
}
