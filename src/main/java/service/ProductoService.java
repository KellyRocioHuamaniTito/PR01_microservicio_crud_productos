package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
    List<Producto> catalogo();
    List<Producto> productoCategoria (String categoria);
    Producto productoCodigo(int cod);
    void altaProducto(Producto producto);
    Producto eliminarProducto(int cod);
    Producto actualizarPrecio(int cod, double precio);

    
}
