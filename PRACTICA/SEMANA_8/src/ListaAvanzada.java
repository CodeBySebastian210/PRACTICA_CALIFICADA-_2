public class ListaAvanzada {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    Nodo head;

    public void insertar(int dato) {

        Nodo nuevo = new Nodo(dato);

        if (head == null) {
            head = nuevo;
            return;
        }

        Nodo actual = head;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    public void mostrar() {

        Nodo actual = head;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    public void invertir() {

        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente;

        while (actual != null) {

            siguiente = actual.siguiente;
            actual.siguiente = anterior;

            anterior = actual;
            actual = siguiente;
        }

        head = anterior;
    }

    public boolean detectarCiclo() {

        Nodo lento = head;
        Nodo rapido = head;

        while (rapido != null &&
               rapido.siguiente != null) {

            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    public static ListaAvanzada fusionar(
            ListaAvanzada l1,
            ListaAvanzada l2) {

        ListaAvanzada fusion = new ListaAvanzada();

        Nodo a = l1.head;
        Nodo b = l2.head;

        while (a != null && b != null) {

            if (a.dato < b.dato) {
                fusion.insertar(a.dato);
                a = a.siguiente;
            } else {
                fusion.insertar(b.dato);
                b = b.siguiente;
            }
        }

        while (a != null) {
            fusion.insertar(a.dato);
            a = a.siguiente;
        }

        while (b != null) {
            fusion.insertar(b.dato);
            b = b.siguiente;
        }

        return fusion;
    }

    public static void main(String[] args) {

        ListaAvanzada lista = new ListaAvanzada();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        System.out.println("Lista original:");
        lista.mostrar();

        lista.invertir();

        System.out.println("Lista invertida:");
        lista.mostrar();

        System.out.println(
            "¿Tiene ciclo?: "
            + lista.detectarCiclo()
        );

        ListaAvanzada l1 = new ListaAvanzada();
        ListaAvanzada l2 = new ListaAvanzada();

        l1.insertar(1);
        l1.insertar(3);
        l1.insertar(5);

        l2.insertar(2);
        l2.insertar(4);
        l2.insertar(6);

        ListaAvanzada fusion = fusionar(l1, l2);

        System.out.println("Lista fusionada:");
        fusion.mostrar();
    }
}