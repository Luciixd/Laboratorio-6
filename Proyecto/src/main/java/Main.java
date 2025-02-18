/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Main {

    public static void main(String[] args) {
        if (!Usuario.autenticar()) {
            return;
        }

        GestorPedidos gestor = new GestorPedidos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Pedidos ---");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Agregar repartidor");
            System.out.println("3. Asignar pedido a repartidor");
            System.out.println("4. Marcar pedido como entregado");
            System.out.println("5. Reporte de pedidos por zona");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Zona: ");
                    String zona = scanner.nextLine();
                    gestor.agregarPedido(cliente, direccion, zona);
                    break;
                case 2:
                    System.out.print("Nombre del repartidor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    gestor.agregarRepartidor(nombre, telefono);
                    break;
                case 3:
                    System.out.print("ID del pedido: ");
                    String idPedido = scanner.nextLine();
                    System.out.print("Nombre del repartidor: ");
                    String nombreRepartidor = scanner.nextLine();
                    gestor.asignarPedidoARepartidor(idPedido, nombreRepartidor);
                    break;
                case 4:
                    System.out.print("ID del pedido a marcar como entregado: ");
                    String idEntregado = scanner.nextLine();
                    gestor.marcarPedidoEntregado(idEntregado);
                    break;
                case 5:
                    gestor.reportePedidosPorZona();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
    
}
