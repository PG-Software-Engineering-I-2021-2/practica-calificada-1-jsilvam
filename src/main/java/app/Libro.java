package app;

public class Libro {
    
    private final String nombre;
    private final Integer anho;
    private final Autor autor;
    private Integer cantidad;

    public Libro(String nombre, Integer anho, Autor autor, Integer cantidad) {
        this.nombre = nombre;
        this.anho = anho;
        this.autor = autor;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public Integer getAnho() {
        return anho;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer addCantidad(Integer cantidad) {
        this.cantidad = this.cantidad + cantidad;
        return this.cantidad;
    }

    public Integer removerCantidad(Integer cantidad) {
        this.cantidad = this.cantidad - cantidad;
        return this.cantidad;
    }

    public Boolean verificarDisponibilidad(Integer cantidad) {
        return ((this.cantidad - cantidad)>=0);
    }

}
