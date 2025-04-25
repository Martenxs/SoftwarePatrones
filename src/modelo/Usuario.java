package modelo;

public class Usuario {
    private String nombre;
    private int nivelAcceso; // Ejemplo: 1 = bajo, 2 = medio, 3 = alto

    public Usuario(String nombre, int nivelAcceso) {
        this.nombre = nombre;
        this.nivelAcceso = nivelAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }
}

