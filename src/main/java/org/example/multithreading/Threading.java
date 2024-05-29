package org.example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * write a program that starts three threads. The first thread should print "A" five times, the second thread should print "B" five times,
 * and the third thread should print "C" five times. The required output order should be "ABCABCABCABCABC".
 */

public class Threading{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            int x = 0;
            while (x < 5) {
                service.submit(getTask("A")).get();
                service.submit(getTask("B")).get();
                service.submit(getTask("C")).get();
                x++;
            }
            service.shutdown();
        }
    }

    private static Callable<String> getTask(String task) {
        return () -> {
            System.out.print(task);
            return task;
        };
    }
}
