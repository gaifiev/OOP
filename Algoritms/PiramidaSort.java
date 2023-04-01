package Algoritms;

import java.util.Scanner;

public class PiramidaSort {
    static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static void print_arr(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static String[] input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Введите числа массив через пробел: ---> ");
        String[] str = input.nextLine().split(" ");
        input.close();
        return str;
    }

    public static void main(String args[]) {
        String[] str = input();
        int array[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        sort(array);
        System.out.println("Отсортированный массив:");
        print_arr(array);
    }
}
