package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    /*CachedThreadPool internally uses synchronous queue (this can hold only one task)*/

    /*if can hold only one task at a time
    * if threads are busy it will create new thread and execute the task (so no need to provide size)
    * if thread is idle then it will reuse that same thread
    * if a thread is idle for 60 seconds it will terminate that thread*/

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new CachedThreadPool.Task());
        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("this is cached thread poll");;
        }
    }
}
