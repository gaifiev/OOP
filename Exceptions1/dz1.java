package Exceptions1;

import java.util.*;

// 1. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив. Метод должен пройтись по каждому элементу и проверить что он не равен null.
// А теперь реализуйте следующую логику:
// Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
// Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
public class dz1 {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4 };
        int arr2[] = { 1, 2, 3 };
        int arrDiv[] = DivisionArr(arr1, arr2);
        System.out.println(Arrays.toString(arrDiv));
    }

    static int[] DivisionArr(int[] arr1, int[] arr2) {
        int arrDiv[] = new int[arr1.length];
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        } else {
            for (int i = 0; i < arr1.length; i++) {
                arrDiv[i] = arr1[i] / arr2[i];
            }
            return arrDiv;
        }
    }
}
