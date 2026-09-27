public class ListaEnlazadaSimple {
    private NodoTicket primero;

    public ListaEnlazadaSimple() {
        primero = null;
    }

    public void insertarNodoFinal(Ticket ticket) {
        NodoTicket nuevoNodo = new NodoTicket(ticket);

        if (primero == null) {
            primero = nuevoNodo;
            return;
        }

        NodoTicket nodoTemp = primero;
        while (nodoTemp.getSiguiente() != null) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        nodoTemp.setSiguiente(nuevoNodo);
    }

    public Ticket buscarNodo(int idBuscar) {
        if (primero == null) {
            return null;
        }

        NodoTicket nodoActual = primero;
        while (nodoActual != null && nodoActual.getDato().getId() != idBuscar) {
            nodoActual = nodoActual.getSiguiente();
        }

        return (nodoActual != null) ? nodoActual.getDato() : null;
    }

    public void mostrarLista() {
        if (primero == null) {
            System.out.println("No hay tickets resueltos aún\n");
            return;
        }

        NodoTicket nodoActual = primero;
        while (nodoActual != null) {
            System.out.println(nodoActual.getDato());
            System.out.println("-------------------");
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
