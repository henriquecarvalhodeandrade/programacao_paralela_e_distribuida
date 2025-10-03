
public class Producer implements Runnable {
    private final SharedList sharedList;

    public Producer(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) { 
            try {
                sharedList.produce(value++);
            
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Produtora interrompida.");
                break;
            }
        }
    }
}