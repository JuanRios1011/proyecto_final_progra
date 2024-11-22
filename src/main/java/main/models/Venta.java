package main.models;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private int idVenta;
    private List<Producto> productosVendidos;
    private double totalVenta;
    private LocalDateTime fechaHora;

    public Venta(int idVenta, List<Producto> productosVendidos, double totalVenta, LocalDateTime fechaHora) {
        this.idVenta = idVenta;
        this.productosVendidos = productosVendidos;
        this.totalVenta = totalVenta;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters
    public int getIdVenta() { return idVenta; }
    public List<Producto> getProductosVendidos() { return productosVendidos; }
    public double getTotalVenta() { return totalVenta; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(idVenta).append(",").append(totalVenta).append(",").append(fechaHora).append(",");
        for (Producto producto : productosVendidos) {
            builder.append(producto.getId()).append("|");
        }
        return builder.toString();
    }
}