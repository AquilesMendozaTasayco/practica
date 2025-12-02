package repository;

import model.Producto;
import java.util.HashMap;
import java.util.Map;

public class ProductoRepositoryImpl implements ProductoRepository {

    private Map<Integer, Producto> inventario = new HashMap<>();

    @Override
    public Map<Integer, Producto> getInventario() {
        return inventario;
    }

    @Override
    public Producto buscarPorId(int id) {
        return inventario.get(id);
    }

    @Override
    public void agregarProducto(Producto producto) {
        inventario.put(producto.getId(), producto);
    }

    @Override
    public void actualizarStock(int id, int nuevoStock) {
        inventario.get(id).setStock(nuevoStock);
    }
}
