package model;

public class ProductoElectronico extends Producto {

    private int garantiaMeses;

    public ProductoElectronico(int id, String nombre, double precio, int stock, int garantiaMeses) {
        super(id, nombre, precio, stock);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularPrecioFinal() {
        return precio * 1.10;
    }
}
