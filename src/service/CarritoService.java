package service;

import model.Producto;
import repository.ProductoRepository;
import exception.StockInsuficienteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarritoService {

    private List<Producto> carrito = new ArrayList<>();
    private ProductoRepository repository;

    public CarritoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public void agregarAlCarrito(int idProducto, int cantidad) throws StockInsuficienteException {
        Producto p = repository.buscarPorId(idProducto);

        if (p == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        if (p.getStock() < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente");
        }

        for (int i = 0; i < cantidad; i++) {
            carrito.add(p);
        }

        repository.actualizarStock(idProducto, p.getStock() - cantidad);
    }

    public Map<Producto, Integer> getCarritoAgrupado() {
        Map<Producto, Integer> agrupado = new HashMap<>();

        for (Producto p : carrito) {
            agrupado.put(p, agrupado.getOrDefault(p, 0) + 1);
        }

        return agrupado;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }
}
