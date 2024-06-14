package org.nsu.oop.task4.threadPool;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final int number_of_workers;
    private final ArrayList<Thread> workers;
    private final LinkedBlockingQueue<Runnable> queue;

    public ThreadPool(int pool_size){
        number_of_workers = pool_size;
        workers = new ArrayList<>();
        queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < number_of_workers; i++){
            workers.add(new Thread(() -> {
                while (true){
                    try{
                        queue.take().run();
                    }
                    catch(InterruptedException e){
                        break;
                    }
                }
            }));

            workers.get(i).start();
        }
    }

    public ThreadPool(){
        this(Runtime.getRuntime().availableProcessors());
    }

    public void addJobToQueue(Runnable job){
        try{
            queue.put(job);
        }
        catch(InterruptedException ignored){}
    }

    public void stop(){
        for (Thread w: workers){
            try{
                w.interrupt();
                w.join();
            }
            catch(InterruptedException ignored){}
        }
    }

    public int getNumber_of_workers(){
        return number_of_workers;
    }

    public synchronized int getQueueSize(){
        return queue.size();
    }
}
