package model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String id;
    private String contacto;
    private List<Reserva> reservas;

    public Cliente(String nombre, String id, String contacto){
        this.nombre = nombre;
        this.id = id;
        this.contacto = contacto;
        this.reservas = new ArrayList<>();
    }

    public void realizarReserva(Reserva reserva){
        reservas.add(reserva);
        System.out.println("Reserva realizada con exito, muchas gracias " + nombre + " por utilizar nuestros servicios.");
    }

    public void cancelarReserva(String reservaId){
        reservas.removeIf(r -> r.getId().equals(reservaId));
        System.out.println("Reserva " + reservaId + " cancelada");
    }

    public String getNombre() { return  nombre;}
    public String getId() { return id;}
    public String getContacto() { return contacto;}
    public List<Reserva> getReservas() { return reservas;}
}
