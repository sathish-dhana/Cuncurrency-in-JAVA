package ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadedExecutor {

    /*SingleThreadedExecutor internally uses only one thread (uses blocking queue)*/

    /*single threaded executor will run task one by one
    * we can you this to run task sequentially */

    
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            //this will execute after time delay of i
            scheduledExecutorService.schedule(new Task(), i, TimeUnit.SECONDS);
        }
//        this will execute after time delay of i after every 5 seconds (ex : this we can use to perform login checks at frequent interval)
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 5, 2, TimeUnit.SECONDS);

        //this will execute after time delay of i after every 5 seconds (ex : this we can use to perform login checks at frequent interval)
        scheduledExecutorService.scheduleWithFixedDelay(new Task(), 2, 1, TimeUnit.SECONDS);
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
