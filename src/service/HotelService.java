package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<ServicioAdicional> servicios;

    public HotelService() {
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.servicios = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {

        habitaciones.add(new HabitacionEstandar("101", 100.0, true, false));
        habitaciones.add(new HabitacionEstandar("102", 120.0, true, true));
        habitaciones.add(new HabitacionSuite("201", 250.0, true, true));
        habitaciones.add(new HabitacionSuite("202", 300.0, true, false));
        habitaciones.add(new HabitacionFamiliar("301", 180.0, true, 6));  // Nueva
        habitaciones.add(new HabitacionDeluxe("401", 400.0, true, true)); // Nueva


        servicios.add(new ServicioAdicional("SPA", "Acceso al spa por 1 hora", 50.0));
        servicios.add(new ServicioAdicional("Desayuno", "Desayuno buffet", 20.0));
        servicios.add(new ServicioAdicional("Lavandería", "Servicio de lavandería express", 15.0));
        servicios.add(new ServicioAdicional("Champagne", "Botella premium", 100.0)); // Para Deluxe
    }

    public List<Habitacion> buscarHabitacionesDisponibles(TipoHabitacion tipo) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible() && (tipo == null || habitacion.getTipo() == tipo)) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    public Cliente registrarCliente(String nombre, String id, String contacto) {
        Cliente cliente = new Cliente(nombre, id, contacto);
        clientes.add(cliente);  // Corregido: usar 'clientes' en lugar de 'cliente.add()'
        return cliente;
    }


    public List<ServicioAdicional> getServiciosDisponibles() {
        return new ArrayList<>(servicios); // Retorna copia para evitar modificaciones externas
    }

    public List<Habitacion> getTodasHabitaciones() {
        return new ArrayList<>(habitaciones);
    }
}