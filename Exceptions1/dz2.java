package Exceptions1;

import java.util.*;

// 2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен сумме элементов двух 
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
public class dz2 {
    public static void main(String[] args) {
        int[] array1 = { 5, 9, 2, 7, 5, 6 };
        int[] array2 = { 15, 97, 1, 8, 5, 1 };
        int[] result = getDiv(array1, array2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getDiv(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Anyone of arrays is equal to NULL");
        } else if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов должны быть равны. Длины разные.");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Нельзя делить на ноль");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
