package com.week2.ConcurrentCollections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections{

    public static void main(String[] args) {
        // Using ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);

        Runnable mapTask = () -> {
            for (int i = 0; i < 5; i++) {
                concurrentMap.put("A", concurrentMap.get("A") + 1);
                System.out.println(Thread.currentThread().getName() + " updated A to " + concurrentMap.get("A"));
            }
        };

        Thread thread1 = new Thread(mapTask);
        Thread thread2 = new Thread(mapTask);
        thread1.start();
        thread2.start();

        // Using CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");

        Runnable listTask = () -> {
            list.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " added an element. List: " + list);
        };

        Thread thread3 = new Thread(listTask);
        Thread thread4 = new Thread(listTask);
        thread3.start();
        thread4.start();
    }
}
