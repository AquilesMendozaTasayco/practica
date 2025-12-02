package model;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private List<Producto> productos;
    private double total;
    private LocalDateTime fecha;

    public Venta(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
