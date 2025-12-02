package model;

import java.util.ArrayList;
import java.util.List;

public class HistorialVenta {

    private List<Venta> historial = new ArrayList<>();

    public void agregarVenta(Venta venta) {
        historial.add(venta);
    }

    public List<Venta> getHistorial() {
        return historial;
    }
}
