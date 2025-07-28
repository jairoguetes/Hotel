package model;

public abstract class Habitacion {
    private String numero;
    private TipoHabitacion tipo;
    private double precioBase;
    private boolean disponible;

    public Habitacion(String numero, TipoHabitacion tipo, double precioBase){
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.disponible = true;
    }

    public void reservar(){
        if(disponible){
            disponible = false;
        }else{
            throw new IllegalStateException("La habitacion en estos momentos no esta disponible");
        }
    }

    public void liberar(){
        disponible = true;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public abstract double calcularCosto(int dias);

    public String getNumero() { return numero;}
    public TipoHabitacion getTipo() { return tipo;}
    public double getPrecioBase() { return precioBase;}
}