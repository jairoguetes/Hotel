import model.*;
import service.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            HotelService hotelService = new HotelService();
            ReservaService reservaService = new ReservaService(hotelService);

            Cliente cliente = hotelService.registrarCliente("Ana López", "67890", "ana@email.com");

            System.out.println("\n=== Habitaciones disponibles ===");
            buscarYReservar(hotelService, reservaService, cliente, TipoHabitacion.FAMILIAR);
            buscarYReservar(hotelService, reservaService, cliente, TipoHabitacion.DELUXE);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void buscarYReservar(HotelService hotelService, ReservaService reservaService,
                                        Cliente cliente, TipoHabitacion tipo) {
        List<Habitacion> disponibles = hotelService.buscarHabitacionesDisponibles(tipo);

        if (disponibles.isEmpty()) {
            System.out.println("No hay " + tipo + " disponibles");
            return;
        }

        Date hoy = new Date();
        Date mañana = new Date(hoy.getTime() + (1000 * 60 * 60 * 24));

        Habitacion habitacion = disponibles.get(0);
        Reserva reserva = reservaService.crearReserva(hoy, mañana, cliente, habitacion);

        if (tipo == TipoHabitacion.DELUXE) {
            hotelService.getServiciosDisponibles().stream()
                    .filter(s -> s.getNombre().equals("Champagne"))
                    .findFirst()
                    .ifPresent(reserva::agregarServicio);
        }

        reserva.confirmar();
        System.out.println("\nReserva " + tipo + ":");
        System.out.println("- ID: " + reserva.getId());
        System.out.println("- Habitación: " + habitacion.getNumero());
        System.out.println("- Costo total: $" + reserva.calcularCostoTotal());
        System.out.println("- Servicios: " + reserva.getServiciosAdicionales().stream()
                .map(ServicioAdicional::getNombre)
                .toList());
    }
}