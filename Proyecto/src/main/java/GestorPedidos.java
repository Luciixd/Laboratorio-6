/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author USUARIO
 */
public class GestorPedidos {

    private ArrayList<Pedido> pedidos;
    private ArrayList<Repartidor> repartidores;

    public GestorPedidos() {
        pedidos = new ArrayList<>();
        repartidores = new ArrayList<>();
    }

    public void agregarPedido(String cliente, String direccion, String zona) {
        Pedido nuevoPedido = new Pedido(cliente, direccion, zona);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido registrado con éxito: " + nuevoPedido.getId());
    }

    public void agregarRepartidor(String nombre, String telefono) {
        Repartidor nuevoRepartidor = new Repartidor(nombre, telefono);
        repartidores.add(nuevoRepartidor);
    }

    public void asignarPedidoARepartidor(String idPedido, String nombreRepartidor) {
        Pedido pedido = buscarPedido(idPedido);
        Repartidor repartidor = buscarRepartidor(nombreRepartidor);

        if (pedido != null && repartidor != null) {
            pedido.asignarRepartidor(repartidor);
            System.out.println("Pedido asignado a " + repartidor.getNombre());
        } else {
            System.out.println("Pedido o repartidor no encontrado.");
        }
    }

    public void marcarPedidoEntregado(String idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.marcarEntregado();
            System.out.println("Pedido entregado con éxito.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public void reportePedidosPorZona() {
        HashMap<String, Integer> reporte = new HashMap<>();
        for (Pedido pedido : pedidos) {
            reporte.put(pedido.getZona(), reporte.getOrDefault(pedido.getZona(), 0) + 1);
        }

        System.out.println("Reporte de pedidos por zona:");
        for (String zona : reporte.keySet()) {
            System.out.println("Zona " + zona + ": " + reporte.get(zona) + " pedidos");
        }
    }

    private Pedido buscarPedido(String id) {
        for (Pedido p : pedidos) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    private Repartidor buscarRepartidor(String nombre) {
        for (Repartidor r : repartidores) {
            if (r.getNombre().equalsIgnoreCase(nombre)) return r;
        }
        return null;
    }
    
}
