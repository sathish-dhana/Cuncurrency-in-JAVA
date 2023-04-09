package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    /*FixedThreadPool internally uses blocking queue (thread safe queue)*/

    /*this we need to use for cpu intensive operation (creating hash function, creating come algorithm)
    * if we have four core processor this will create only 4 threads
    * since creating many threads will decrease the performance because once core will be shared by multiple threads
    * At that time we can use this Executors.newFixedThreadPool to increase efficiency*/

    /*When to use more threads
    * If you are performing any IO opertaions (like reading files from database, for calling external api for data
    * our cpu needs to wait for response, this will decrease performance if we run ony one thread in one core
    * At that time we can increase more threads
    * this will increase performance since if one thread waits for response, cpu core will execute next thread */

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new CpuIntensiveOperation());
        }
    }

    public static class CpuIntensiveOperation implements Runnable {
        @Override
        public void run() {
            System.out.println("this is cpu intensive");;
        }
    }
}
