
public class Consumer implements Runnable {
    private final SharedList sharedList;

    public Consumer(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (true) { 
            try {
                int value = sharedList.consume();
                System.out.println(">> Valor impresso por T2: " + value);
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Consumidora interrompida.");
                break;
            }
        }
    }
}