public class NodoTicket {
    private Ticket dato;
    private NodoTicket siguiente;

    public NodoTicket(Ticket dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Ticket getDato() {
        return dato;
    }

    public NodoTicket getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTicket siguiente) {
        this.siguiente = siguiente;
    }
}
