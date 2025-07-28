package model;

public class ServicioAdicional {
    private String nombre;
    private String descripcion;
    private double precio;


    public ServicioAdicional(String nombre, String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void agregarReserva(Reserva reserva){
        reserva.agregarServicio(this);
    }

    public String getNombre() { return nombre;}
    public String getDescripcion() {return  descripcion;}
    public double getPrecio() { return precio;}
}
