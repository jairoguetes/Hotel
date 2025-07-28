package model;

public class HabitacionDeluxe extends Habitacion {
    private boolean champagneIncluido;
    private boolean accesoVIP;

    public HabitacionDeluxe(String numero, double precioBase, boolean champagneIncluido, boolean accesoVIP){
        super(numero, TipoHabitacion.DELUXE, precioBase);
        this.champagneIncluido = champagneIncluido;
        this.accesoVIP = accesoVIP;
    }
    @Override
    public double calcularCosto(int dias){
        double costo = getPrecioBase() * dias;
        if(champagneIncluido){
            costo += 100 * dias;
        }
        return costo;
    }

    public boolean incluyeChampagne() { return champagneIncluido; }
    public boolean tieneAccesoVIP() { return accesoVIP; }
}