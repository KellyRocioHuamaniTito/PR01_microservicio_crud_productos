package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor //incorpore los contructores
@Data //incluye los setter y getter
public class Producto {
    private int codProducto;
    private String nombre;
    private String categoria;
    private double precioUnitario;
    private int stock;



}
