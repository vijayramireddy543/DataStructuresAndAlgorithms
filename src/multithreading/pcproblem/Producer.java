package multithreading.pcproblem;

import java.util.List;

public class Producer implements Runnable{
    private final List<Integer> queue;
    final Integer MAX_VALUE;

    public Producer(List<Integer> queue, Integer MAX_VALUE) {
        this.queue = queue;
        this.MAX_VALUE = MAX_VALUE;
    }

    @Override
    public void run() {
        try {
            int counter = 0;
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_VALUE) {
                        queue.wait();
                        System.out.println("Queue is full waiting" + counter);
                    }
                    //Thread.sleep(1000);
                    queue.add(counter++);
                    System.out.println("Produced " + (counter - 1));
                    queue.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("InterruptedException is " + e);
        }
    }
}
