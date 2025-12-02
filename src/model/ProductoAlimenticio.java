package model;

import java.time.LocalDate;

public class ProductoAlimenticio extends Producto {

    private LocalDate fechaCaducidad;

    public ProductoAlimenticio(int id, String nombre, double precio, int stock, LocalDate fechaCaducidad) {
        super(id, nombre, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
}
