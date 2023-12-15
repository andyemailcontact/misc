package com.eileenvivian;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

interface DoIt {
    void letsGo();
}

public class Threads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        char c = '7';
        // just minus the offset of actual int value of zero '0'
        //System.out.println("Value of " + c + " is " + (c - '0'));

        Callable<String> callback = () -> { return "Hey now"; } ;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        Future<String> ret = executor.submit(callback);
        System.out.println(ret.get());
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public void invokeAllExample() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
    }
}
