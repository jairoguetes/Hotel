package service;

import model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaService {
    private HotelService hotelService;
    private List<Reserva> reservas;

    public ReservaService(HotelService hotelService) {
        this.hotelService = hotelService;
        this.reservas = new ArrayList<>();
    }

    public Reserva crearReserva(Date fechaInicio, Date fechaFin,
                                Cliente cliente, Habitacion habitacion) {
        Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente, habitacion);
        reservas.add(reserva);
        cliente.realizarReserva(reserva);
        return reserva;
    }

    public void cancelarReserva(String reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(reservaId)) {
                reserva.cancelar();
                break;
            }
        }
    }

    public List<Reserva> obtenerReservasPorCliente(String clienteId) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getId().equals(clienteId)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }
}