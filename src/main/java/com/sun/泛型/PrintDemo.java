package com.sun.泛型;

/**
 * create by qiulisun on 2020/12/7.<br>
 */
public class PrintDemo {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        printArray(array);
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s", element);
        }
    }
}
