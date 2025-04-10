package vista;

import modelo.Cliente;
import modelo.ClienteFacade;
import modelo.FormaPago;
import modelo.Pedido;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaCliente {
    private ClienteFacade facade;
    private ComboBox<String> comboFormasPago;
    private TextArea output;

    public VistaCliente(Stage stage) {
        // Crear objetos necesarios para el constructor
        Cliente cliente = new Cliente("Juan", "juan@gmail.com");
        List<FormaPago> formasPago = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        this.facade = new ClienteFacade(cliente, formasPago, pedidos);

        // Layout principal
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        // Área de texto de salida
        output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(200);

        // ComboBox para seleccionar forma de pago
        comboFormasPago = new ComboBox<>();
        comboFormasPago.setPromptText("Selecciona forma de pago");
        comboFormasPago.setPrefWidth(200);

        // Botones
        Button btnMostrarCliente = new Button("Mostrar Cliente");
        btnMostrarCliente.setOnAction(e -> output.setText(facade.mostrarCliente()));

        Button btnActualizarCliente = new Button("Actualizar Cliente");
        btnActualizarCliente.setOnAction(e -> output.setText(facade.actualizarCliente("Ana", "ana@gmail.com")));

        Button btnAgregarPago = new Button("Agregar Forma de Pago");
        btnAgregarPago.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Agregar forma de pago");
            dialog.setContentText("Método:");
            dialog.showAndWait().ifPresent(metodo -> {
                output.setText(facade.agregarFormaPago(metodo));
                actualizarComboBox(); // Actualiza el ComboBox después de agregar
            });
        });

        Button btnBloquearPago = new Button("Bloquear Pago");
        btnBloquearPago.setOnAction(e -> {
            String metodo = comboFormasPago.getValue();
            if (metodo != null) {
                output.setText(facade.bloquearPago(metodo));
            }
        });

        Button btnVerPagos = new Button("Ver Formas de Pago");
        btnVerPagos.setOnAction(e -> output.setText(facade.mostrarFormasPago()));

        Button btnPedido = new Button("Hacer Pedido");
        btnPedido.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Nuevo Pedido");
            dialog.setContentText("Descripción:");
            dialog.showAndWait().ifPresent(desc -> output.setText(facade.realizarPedido(desc)));
        });

        Button btnHistorial = new Button("Ver Historial");
        btnHistorial.setOnAction(e -> output.setText(facade.mostrarHistorialPedido()));

        // Distribución en GridPane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(btnMostrarCliente, 0, 0);
        grid.add(btnActualizarCliente, 1, 0);
        grid.add(btnAgregarPago, 0, 1);
        grid.add(comboFormasPago, 1, 1);
        grid.add(btnBloquearPago, 0, 2);
        grid.add(btnVerPagos, 1, 2);
        grid.add(btnPedido, 0, 3);
        grid.add(btnHistorial, 1, 3);

        // Agregar todo al root
        root.getChildren().addAll(grid, output);

        // Escena y Stage
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Vista Cliente");
        stage.show();

        actualizarComboBox(); // Cargar combo al inicio
    }

    // Método auxiliar para actualizar ComboBox con formas de pago
    private void actualizarComboBox() {
        comboFormasPago.getItems().clear();

        // Parsear resultado de mostrarFormasPago()
        String[] lineas = facade.mostrarFormasPago().split("\n");
        for (String linea : lineas) {
            if (!linea.trim().isEmpty()) {
                String metodo = linea.split(" - ")[0].trim();
                comboFormasPago.getItems().add(metodo);
            }
        }
    }
}
