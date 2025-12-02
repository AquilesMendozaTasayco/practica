package repository;

import model.Producto;
import java.util.Map;

public interface ProductoRepository {
    Map<Integer, Producto> getInventario();
    Producto buscarPorId(int id);
    void agregarProducto(Producto producto);
    void actualizarStock(int id, int nuevoStock);
}
