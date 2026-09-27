import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SistemaTickets {
    private PriorityQueue<Ticket> ticketsPendientes;
    private ListaEnlazadaSimple ticketsResueltos;
    private Scanner scanner;

    public SistemaTickets() {
        ticketsPendientes = new PriorityQueue<>();
        ticketsResueltos = new ListaEnlazadaSimple();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("*** Sistema de Gestión de Tickets ***");
            System.out.println("1. Menu de Usuario");
            System.out.println("2. Menu de Administrador");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.\n");
            }
        } while (opcion != 0);
    }

    private void menuUsuario() {
        int opcion;

        do {
            System.out.println("\n*** Menú de Usuario ***");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    crearTicket();
                    break;
                case 2:
                    buscarTicketResuelto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida.\n");
            }
        } while (opcion != 0);
    }

    private void crearTicket() {
        scanner.nextLine();
        System.out.print("Ingrese la descripcion del ticket: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        Ticket nuevoTicket = new Ticket(descripcion, nombreCompleto);
        ticketsPendientes.add(nuevoTicket);

        System.out.println("Ticket creado con exito. Su numero de ticket es: "
                + nuevoTicket.getId() + "\n");
    }

    private void buscarTicketResuelto() {
        System.out.print("Ingrese el id del ticket a buscar: ");
        int id = leerOpcion();

        Ticket encontrado = ticketsResueltos.buscarNodo(id);

        if (encontrado != null) {
            System.out.println("Ticket encontrado:");
            System.out.println(encontrado + "\n");
        } else {
            System.out.println("El ticket #" + id + " esta pendiente de resolucion.\n");
        }
    }

    private void menuAdministrador() {
        int opcion;

        do {
            System.out.println("\n*** Menú de Administrador *** ");
            System.out.println("1. Ver ticket al frente de la cola");
            System.out.println("2. Resolver ticket al frente de la cola");
            System.out.println("3. Ver todos los tickets resueltos");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    verFrenteCola();
                    break;
                case 2:
                    resolverTicket();
                    break;
                case 3:
                    ticketsResueltos.mostrarLista();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida.\n");
            }
        } while (opcion != 0);
    }

    private void verFrenteCola() {
        Ticket frente = ticketsPendientes.peek();

        if (frente == null) {
            System.out.println("No hay tickets pendientes.\n");
        } else {
            System.out.println("Ticket al frente de la cola:");
            System.out.println(frente + "\n");
        }
    }

    private void resolverTicket() {
        Ticket resuelto = ticketsPendientes.poll();

        if (resuelto == null) {
            System.out.println("No hay tickets pendientes para resolver.\n");
            return;
        }

        resuelto.setFechaResolucion(LocalDateTime.now());
        ticketsResueltos.insertarNodoFinal(resuelto);

        System.out.println("Ticket #" + resuelto.getId() + " resuelto con exito.\n");
    }

    private int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
