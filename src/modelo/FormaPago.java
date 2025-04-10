package modelo;

public class FormaPago {
    private String metodo;
    private boolean activo;

    public FormaPago(String metodo) {
        this.metodo = metodo;
        this.activo = true;
    }

    public String getMetodo() {
        return metodo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
