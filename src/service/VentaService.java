package service;

import model.Venta;
import model.Producto;

import java.util.List;

public class VentaService {

    public Venta procesarVenta(List<Producto> carrito) {
        double total = 0;

        for (Producto p : carrito) {
            total += p.calcularPrecioFinal();
        }

        return new Venta(carrito, total);
    }
}
