package Exceptions3;

import java.util.*;

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, 
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. 
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), 
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException 
// и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
public class Program {

    public static void main(String[] args) {
        String[][] array1 = new String[][] {
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "4", "5", "6" },
                { "1", "3", "4", "5" }
        };
        String[][] array2 = new String[][] {
                { "2", "3", "4" },
                { "6", "7", "8", "9" },
                { "2", "3", "4", "5" },
                { "6", "7", "8", "9" }
        };
        String[][] array3 = new String[][] {
                { "2", "3", "4", "10" },
                { "2", "3", "4", "5" },
                { "2", "3", "4", "5" },
                { "2", "3", "4", "5" },
                { "6", "7", "8", "9" }
        };
        String[][] array4 = new String[][] {
                { "1", "qwert", "6", "3" },
                { "8", "9", "10", "11" },
                { "4", "5", "6", "7" },
                { "8", "9", "10", "1" }
        };

        int output = 0;
        try {
            output = test(array1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println("1. По всем элементам массива преобразовываем в int и просуммируем: " + output);

        try {
            output = test(array2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println("2. По всем элементам массива преобразовываем в int и просуммируем: " + output);

        try {
            output = test(array3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println("3. По всем элементам массива преобразовываем в int и просуммируем: " + output);

        try {
            output = test(array4);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println("4. По всем элементам массива преобразовываем в int и просуммируем: " + output);
        System.exit(0);
    }

    private static int test(String[][] input) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (input.length != 4)
            throw new MyArraySizeException(String.format("Размер массива не равен %d: ", input.length));

        for (int i = 0; i < input.length; i++) {
            if (input[i].length != 4)
                throw new MyArraySizeException(String.format("Некорректное количество элементов %d в %d" + " строке",
                        input[i].length, i));
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                try {
                    sum += Integer.parseInt(input[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(
                            String.format("Некорректный формат числа в позиции %d, %d: \"%s\"", i, j, input[i][j]));
                }
            }
        }
        return sum;
    }
}
