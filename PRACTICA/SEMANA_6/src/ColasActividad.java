import java.util.LinkedList;
import java.util.PriorityQueue;

public class ColasActividad {
    public static void main(String[] args) {
        int colaCircular[] = new int[5];
        int frente = 0, fin = 0;

        colaCircular[fin] = 10;
        fin = (fin + 1) % 5;

        colaCircular[fin] = 20;
        fin = (fin + 1) % 5;

        System.out.println("Cola Circular dequeue: " + colaCircular[frente]);
        frente = (frente + 1) % 5;

        LinkedList<Integer> colaLista = new LinkedList<>();

        colaLista.add(30); 
        colaLista.add(40);

        System.out.println("Cola Lista dequeue: " + colaLista.remove());

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();

        colaPrioridad.add(50);
        colaPrioridad.add(10);
        colaPrioridad.add(30);

        System.out.println("Cola Prioridad dequeue: " + colaPrioridad.poll());
        
        System.out.println("Cola Lista actual: " + colaLista);
        System.out.println("Cola Prioridad actual: " + colaPrioridad);
    }    
}
