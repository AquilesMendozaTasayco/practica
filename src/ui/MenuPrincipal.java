package ui;

import exception.StockInsuficienteException;
import model.Producto;
import model.ProductoAlimenticio;
import model.ProductoElectronico;
import model.Venta;
import repository.ProductoRepositoryImpl;
import service.CarritoService;
import service.InventarioService;
import service.VentaService;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc = new Scanner(System.in);

    public void iniciar() {

        ProductoRepositoryImpl repo = new ProductoRepositoryImpl();
        InventarioService inventarioService = new InventarioService(repo);
        CarritoService carritoService = new CarritoService(repo);
        VentaService ventaService = new VentaService();

        repo.agregarProducto(new ProductoElectronico(101, "Laptop Gamer", 1200, 5, 12));
        repo.agregarProducto(new ProductoElectronico(102, "Mouse Inalámbrico", 25, 20, 6));
        repo.agregarProducto(new ProductoAlimenticio(201, "Leche", 3.5, 15, LocalDate.now().plusDays(10)));

        int opcion;

        do {
            System.out.println("===============================");
            System.out.println("1. Ver Catálogo de Productos");
            System.out.println("2. Ver Carrito de Compras");
            System.out.println("3. Pagar y Salir");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                inventarioService.verInventario().forEach((id, p) ->
                        System.out.println(id + " - " + p.getNombre() + " - $" + p.getPrecio() + " - Stock: " + p.getStock())
                );

                System.out.print("ID del producto: ");
                int id = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();

                try {
                    carritoService.agregarAlCarrito(id, cantidad);
                    System.out.println("Agregado correctamente.");
                } catch (StockInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 2) {
                carritoService.getCarritoAgrupado().forEach((producto, cantidad) -> {
                    System.out.println(producto.getNombre() + " - $" + producto.getPrecio() + " - Cantidad: " + cantidad);
                });

            } else if (opcion == 3) {
                Venta venta = ventaService.procesarVenta(carritoService.getCarrito());
                System.out.println("Total a pagar: $" + venta.getTotal());
                opcion = 4;
            }

        } while (opcion != 4);
    }
}
