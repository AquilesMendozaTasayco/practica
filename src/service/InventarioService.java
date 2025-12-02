package service;

import model.Producto;
import repository.ProductoRepository;

import java.util.Map;

public class InventarioService {

    private ProductoRepository repository;

    public InventarioService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Map<Integer, Producto> verInventario() {
        return repository.getInventario();
    }

    public Producto buscarProducto(int id) {
        return repository.buscarPorId(id);
    }
}
