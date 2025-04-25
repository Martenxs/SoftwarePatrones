package modelo;

import java.util.HashMap;
import java.util.Map;

public class ProveedorFactory {
    private static Map<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor obtenerProveedor(String nombre, String contacto) {
        if (!proveedores.containsKey(nombre)) {
            proveedores.put(nombre, new Proveedor(nombre, contacto));
        }
        return proveedores.get(nombre);
    }
}

