package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;

@Service // clase de logica de negocio 
public class ProductoServiceImpl implements ProductoService{


    private static List<Producto> productos=new ArrayList<>(List.of(new Producto(100,"Azucar","Alimentación",1.10,20),
			new Producto(101,"Leche","Alimentación",1.20,15),
			new Producto(102,"Jabón","Limpieza",0.89,30),
			new Producto(103,"Mesa","Hogar",125,4),
			new Producto(104,"Televisión","Hogar",650,10),
			new Producto(105,"Huevos","Alimentación",2.20,30),
			new Producto(106,"Fregona","Limpieza",3.40,6),
			new Producto(107,"Detergente","Limpieza",8.7,12)));

    @Override
    public List<Producto> catalogo() {
        return productos;
    }

    @Override
    public List<Producto> productoCategoria(String categoria) {
        //programacion funcional
        //.stream() convierte esta colección en un flujo (stream) de objetos 
        /*.filter(...) permite filtrar elementos según una condición.
            p -> p.getCategoria().equals(categoria)  Aquí, p es cada objeto Producto en el flujo.
             La expresión lambda verifica si la categoría del producto (p.getCategoria()) es igual 
             a la categoría proporcionada como argumento (categoria). */
        return productos.stream() 
        .filter(p->p.getCategoria().equals(categoria))
        .toList(); //version mas moderna java 16
        //en lugar de toList() puedes usar collectors
        //.collect(Collectors.toList());
    }

    @Override
    public Producto productoCodigo(int cod) {
        //progración funcional
        return productos.stream()
        .filter(p->p.getCodProducto()==cod)
        .findFirst() // devuelve el primer resultado u objeto
        .orElse(null); // caso contrario null
    }

    @Override
    public void altaProducto(Producto producto) {
        //si el el objeto producto no viene con un codigo 
        //entonces devolverá null y pasara a agregar.
        if(productoCodigo(producto.getCodProducto())==null){
            productos.add(producto);
        }
    }

    @Override
    public Producto eliminarProducto(int cod) {
        Producto producto = productoCodigo(cod);// para obtener el objeto por medio del codigo
        if(producto!=null){
            productos.removeIf(p->p.getCodProducto()==cod);
        }
        return producto;
    }

    @Override
    public Producto actualizarPrecio(int cod, double precio) {
        Producto producto = productoCodigo(cod);
        if(producto!=null){
            producto.setPrecioUnitario(precio);
        }
        return producto;
    }
  
}
