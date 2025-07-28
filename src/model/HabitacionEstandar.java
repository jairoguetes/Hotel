package model;

public class HabitacionEstandar extends Habitacion {
    private boolean wifiGratis;
    private boolean visitaExterior;

    public HabitacionEstandar(String numero, double precioBase, boolean wifiGratis, boolean visitaExterior){
        super(numero, TipoHabitacion.ESTANDAR, precioBase);
        this.wifiGratis = wifiGratis;
        this.visitaExterior = visitaExterior;
    }

    @Override
    public double calcularCosto(int dias){
        double costo = getPrecioBase() * dias;
        if(visitaExterior){
            costo += 15 * dias;
        }
        return costo;
    }

    public boolean tieneWifiGratis() { return wifiGratis; }
    public boolean tieneVisitaExterior() { return visitaExterior;}
}
