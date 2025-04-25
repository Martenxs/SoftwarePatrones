package modelo;

public class FormaPago {
    private boolean activa = true;

    public String mostrarEstado() {
        return activa ? "Forma de pago activa" : "Forma de pago bloqueada";
    }

    public String activar() {
        activa = true;
        return "Forma de pago activada.";
    }

    public String bloquear() {
        activa = false;
        return "Forma de pago bloqueada.";
    }
}

