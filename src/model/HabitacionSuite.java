package model;

public class HabitacionSuite extends Habitacion{
    private boolean serviceRoomService;
    private boolean accesoLounge;

    public HabitacionSuite(String numero, double precioBase, boolean serviceRoomService, boolean accesoLounge){
        super(numero, TipoHabitacion.SUITE, precioBase);
        this.serviceRoomService = serviceRoomService;
        this.accesoLounge = accesoLounge;
    }

    @Override
    public double calcularCosto(int dias){
        double costo = getPrecioBase() * dias;
        if (serviceRoomService){
            costo += 30 * dias;
        }
        if (accesoLounge){
            costo += 50 * dias;
        }
        return costo;
    }
    public boolean tieneServicioRoomService() { return serviceRoomService; }
    public boolean tieneAccesoLounge() { return accesoLounge; }

}
