package model;

/**
 *
 * @author Juan Pablo Tejeiro Londoño
 */
public class Item {
    private String  nombre;
    private Integer cantidad;
    private Double precio;

    public Item(Integer base, Integer altura, Integer profundidad) {
        
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    } 
}
