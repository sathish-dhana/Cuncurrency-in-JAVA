package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledThreadPool {

    /*ScheduledThreadPool internally uses delay queue (in this queue task will execute based on scheduled time)*/

    /*this will run the submitted task at given time delay*/
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("this is cached thread poll");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
