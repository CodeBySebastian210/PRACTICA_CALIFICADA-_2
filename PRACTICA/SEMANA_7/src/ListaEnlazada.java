public class ListaEnlazada {
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    Nodo head;

    public ListaEnlazada() {
        head = null;
    }

    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        nuevo.siguiente = head;
        head = nuevo;
    }

    public void eliminar(int dato) {

        if (head == null) {
            return;
        }

        if (head.dato == dato) {
            head = head.siguiente;
            return;
        }

        Nodo actual = head;

        while (actual.siguiente != null &&
               actual.siguiente.dato != dato) {

            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public void mostrar() {
        Nodo actual = head;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        System.out.println("Lista después de insertar:");
        lista.mostrar();

        lista.eliminar(20);

        System.out.println("Lista después de eliminar 20:");
        lista.mostrar();
    }   
}
