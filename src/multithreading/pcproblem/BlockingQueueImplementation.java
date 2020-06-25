package multithreading.pcproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImplementation<E> {
    Queue<E> list;
    int max_size = 16;
    ReentrantLock lock = new ReentrantLock(true);
    Condition conditionFull = lock.newCondition();// Object full = new Object();
    Condition conditionEmpty = lock.newCondition(); // Object empty = new Object();


    public BlockingQueueImplementation(int max_size) {
        this.list = new LinkedList<>();
        this.max_size = max_size;

    }

    public void put(E e) {
        lock.lock(); // We can write syncronized
        try {
            while (list.size() == max_size) {
                conditionFull.await(); // full.wait();
            }
            list.add(e);
            conditionEmpty.signalAll(); // empty.notify();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        E ele = null;
        try {
            while (list.isEmpty()) {
                conditionEmpty.await();
            }
            ele = list.remove();
            conditionFull.signalAll();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
        return ele;
    }
}
