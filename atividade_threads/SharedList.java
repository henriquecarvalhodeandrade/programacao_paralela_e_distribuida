import java.util.LinkedList;
import java.util.List;

public class SharedList {
    private final List<Integer> list = new LinkedList<>();
    private final int capacity;

    public SharedList(int capacity) {
        this.capacity = capacity;
    }
    @param
    @throws InterruptedException 
    public void produce(int value) throws InterruptedException {
        synchronized (this) {

            while (list.size() == capacity) {
                System.out.println("Lista cheia, a thread Produtora (T1) está esperando...");
                wait(); 
            }

            list.add(value);
            System.out.println("T1 (Produtor) produziu -> " + value);
            notify();  
        }
    }
    @return 
    @throws InterruptedException
    public int consume() throws InterruptedException {
        synchronized (this) { 

            while (list.isEmpty()) {
                System.out.println("Lista vazia, a thread Consumidora (T2) está esperando...");
                wait(); 
            }

            int value = list.remove(0);
            System.out.println("T2 (Consumidor) consumiu <- " + value);

            notify();
            return value;
        }
    }
}