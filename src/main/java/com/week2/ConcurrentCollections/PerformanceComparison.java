package com.week2.ConcurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PerformanceComparison {

    public static void main(String[] args) {
        int numberOfOperations = 10000;

        // Non-Concurrent Collection
        List<String> nonConcurrentList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            nonConcurrentList.add("Element " + i);
        }
        long end = System.nanoTime();
        System.out.println("Non-Concurrent List Time: " + (end - start) + " ns");

        // Concurrent Collection
        List<String> concurrentList = new CopyOnWriteArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            concurrentList.add("Element " + i);
        }
        end = System.nanoTime();
        System.out.println("Concurrent List Time: " + (end - start) + " ns");
    }
}
