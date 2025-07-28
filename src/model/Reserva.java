package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reserva {
    private String id;
    private Date fechaInicio;
    private Date fechaFin;
    private Cliente cliente;
    private Habitacion habitacion;
    private List<ServicioAdicional> serviciosAdicionales;
    private EstadoReserva estado;

    public Reserva(Date fechaInicio, Date fechaFin, Cliente cliente, Habitacion habitacion) {
        this.id = UUID.randomUUID().toString();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.serviciosAdicionales = new ArrayList<>();
        this.estado = EstadoReserva.PENDIENTE;
        habitacion.reservar();
    }

    public double calcularCostoTotal() {
        long diffInMillies = fechaFin.getTime() - fechaInicio.getTime();
        int dias = (int) (diffInMillies / (1000 * 60 * 60 * 24));

        double costo = habitacion.calcularCosto(dias);

        for (ServicioAdicional servicio : serviciosAdicionales) {
            costo += servicio.getPrecio();
        }

        return costo;
    }

    public void confirmar() {
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
        habitacion.liberar();
    }

    public void agregarServicio(ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }


    public String getId() { return id; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public List<ServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
    public EstadoReserva getEstado() { return estado; }
}