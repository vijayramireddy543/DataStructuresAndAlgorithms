package multithreading.pcproblem;

import java.util.concurrent.ConcurrentHashMap;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueueImplementation<Integer> blockingQueueImplementation = new BlockingQueueImplementation<>(10);
        Runnable produce = new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (true) {
                    blockingQueueImplementation.put(counter);
                    System.out.println("Produce: "+counter++ +" Name: "+ Thread.currentThread().getName());
                }
            }
        };
        Thread threadP = new Thread(produce, "Producer");
        Thread threadQ = new Thread(produce, "ProducerQ");
        threadP.start();
        threadQ.start();
        Runnable consume = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int i = blockingQueueImplementation.take();
                    System.out.println("Consume: "+i +" Name: "+Thread.currentThread().getName());
                }
            }
        };
        Thread threadC = new Thread(consume, "Consumer");
        Thread threadD = new Thread(consume, "ConsumerD");
        threadC.start();
        threadD.start();
    }
}
