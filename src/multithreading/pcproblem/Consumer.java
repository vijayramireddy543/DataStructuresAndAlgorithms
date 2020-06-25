package multithreading.pcproblem;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Integer> queue;

    public Consumer(List<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                        System.out.println("Queue is empty waiting");
                    }

                    //Thread.sleep(1000);
                    int i = queue.remove(0);
                    System.out.println("Queue first element removed " + i);
                    try {
                        queue.notifyAll();
                    } catch (Exception e) {
                        System.out.println("Monitor exception " + e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("InterruptedException in consumer "+e);
        }
    }
}
