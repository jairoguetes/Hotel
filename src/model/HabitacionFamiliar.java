package model;

public class HabitacionFamiliar extends Habitacion{
    private boolean cunaGratis;
    private int capacidadMaxima;

    public HabitacionFamiliar(String numero, double precioBase, boolean cunaGratis, int capacidadMaxima){
        super(numero, TipoHabitacion.FAMILIAR, precioBase);
        this.cunaGratis = cunaGratis;
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public double calcularCosto(int dias){
        double costo = getPrecioBase() * dias;
        return costo * 0.9;
    }

    public boolean tieneCunaGratis() { return cunaGratis; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
}
