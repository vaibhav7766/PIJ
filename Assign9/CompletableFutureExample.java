package Assign9;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Create a StringBuilder to build the final result
        StringBuilder sb = new StringBuilder();

        // Create a CompletableFuture that supplies the initial value "Completable"
        CompletableFuture.supplyAsync(() -> {
                    return "Completable";
                })
                // Chain a thenApplyAsync stage to append "Future" to the supplied value
                .thenApplyAsync(s -> sb.append(s).append("Future").toString())
                // Chain a thenAccept stage to print the current value
                .thenAccept(s -> System.out.println("Current value is- " + s))
                // Chain a thenRun stage to print a message indicating computation completion
                .thenRun(() -> System.out.println("Computation finished."));
    }
}
