import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Ticket implements Comparable<Ticket> {
    private static int cantidad = 0;

    private final int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Ticket(String descripcion, String nombreCompleto) {
        this.id = ++cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @Override
    public int compareTo(Ticket otro) {
        return this.fechaCreacion.compareTo(otro.fechaCreacion);
    }

    @Override
    public String toString() {
        String resolucionTexto = (fechaResolucion == null)
                ? "Pendiente"
                : fechaResolucion.format(FORMATO);

        return "Ticket #" + id +
                "\n  Descripción     : " + descripcion +
                "\n  Creado por      : " + nombreCompleto +
                "\n  Fecha creación  : " + fechaCreacion.format(FORMATO) +
                "\n  Fecha resolución: " + resolucionTexto;
    }
}
