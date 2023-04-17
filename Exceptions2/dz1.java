package Exceptions2;

import java.util.Scanner;

// 1) Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class dz1 {
    public static void main(String[] args) {
        System.out.println(Input());
    }

    public static float Input() {
        Float d;
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите дробное число");
            String a = iScanner.nextLine();
            char c = a.charAt(0);
            if (Character.isDigit(c)) {
                d = Float.parseFloat(a);
                iScanner.close();
                return d;
            } else {
                System.out.println("Вы ввели не число");
                continue;
            }
        }
    }
}
