package modelo;

public class ClienteFacade {
    private Cliente cliente;
    private Pedido pedido;
    private FormaPago formaPago;

    public ClienteFacade(String nombre, String correo) {
        this.cliente = new Cliente(nombre, correo);
        this.pedido = new Pedido();
        this.formaPago = new FormaPago();
    }

    public String gestionarInformacionCliente() {
        return cliente.mostrarInformacion();
    }

    public String gestionarPedidos() {
        String pedidoRealizado = pedido.realizarPedido("Arepa de queso");
        return pedidoRealizado + "\n" + pedido.mostrarHistorial();
    }

    public String gestionarFormaPago() {
        String estadoAntes = formaPago.mostrarEstado();
        String bloquear = formaPago.bloquear();
        String estadoDespues = formaPago.mostrarEstado();
        return estadoAntes + "\n" + bloquear + "\n" + estadoDespues;
    }

    // ✅ Método maestro que reúne los 3 subsistemas
    public String gestionarTodo() {
        return "---- Información del Cliente ----\n" +
                gestionarInformacionCliente() + "\n\n" +
                "---- Historial de Pedidos ----\n" +
                gestionarPedidos() + "\n\n" +
                "---- Forma de Pago ----\n" +
                gestionarFormaPago();
    }

    public String actualizarCliente(String nuevoNombre, String nuevoCorreo) {
        return cliente.actualizarInformacion(nuevoNombre, nuevoCorreo);
    }
}

