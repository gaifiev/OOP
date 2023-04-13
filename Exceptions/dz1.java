package Exceptions;

import java.util.*;

// 1. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив. Метод должен пройтись по каждому элементу и проверить что он не равен null.
// А теперь реализуйте следующую логику:
// Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
// Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
public class dz1 {
    public static void main(String[] args) {
        Integer[] array = new Integer[] { 1, 4, null, 1, 4, null, 0 };
        System.out.println(Arrays.toString(array));
        checkArray(array);
    }

    public static void checkArray(Integer[] arr) {
        StringBuilder ram = new StringBuilder();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                count++;
                ram.append(i);
                ram.append(" ");

            }
        }
        if (count != 0) {
            System.out.println("Null in index: ");
            System.out.println(ram.toString());
            throw new RuntimeException("Array element equals null");
        }

    }
}
