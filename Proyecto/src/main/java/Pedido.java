/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.UUID;
/**
 *
 * @author USUARIO
 */
public class Pedido {

    /**
     * @param args the command line arguments
     */
    private String id;
    private String cliente;
    private String direccion;
    private String zona;
    private String estado;
    private Repartidor repartidor;

    public Pedido(String cliente, String direccion, String zona) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.direccion = direccion;
        this.zona = zona;
        this.estado = "Pendiente";
        this.repartidor = null;
    }

    public String getId() {
        return id;
    }

    public String getZona() {
        return zona;
    }

    public String getEstado() {
        return estado;
    }

    public void asignarRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
        this.estado = "En camino";
    }

    public void marcarEntregado() {
        this.estado = "Entregado";
    }

    public String toString() {
        return "Pedido ID: " + id + ", Cliente: " + cliente + ", Dirección: " + direccion +
               ", Zona: " + zona + ", Estado: " + estado + 
               (repartidor != null ? ", Repartidor: " + repartidor.getNombre() : ", Sin repartidor asignado");
    }
    
}
