package home2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // System.out.println("Чё тебе надо? ");
        // System.out.println("1 -> покажи всех родней иеархии");
        // System.out.println("2 -> надо добавить нового человека");
        // System.out.println("3 -> покажи определенного человека по фамилии");
        // System.out.println("4 -> отсортируй всех по фамилии");
        // System.out.println("5 -> пойду спать");
        // Scanner db = new Scanner(System.in, "866");
        // Integer select = db.nextInt();
        // if (select == 1) {

        // } else if (select == 2) {

        // }

        Human gran1 = new Human("Юлия", "Макарова", "women", 80, 1, null, null);
        Human gran2 = new Human("Надежда", "Иванова", "women", 77, 2, null, null);
        Human granddad1 = new Human("Адис", "Макаров", "male", 78, 3, null, null);
        Human granddad2 = new Human("Леонид", "Иванов", "male", 79, 4, null, null);
        Human mother1 = new Human("Ольга", "Макарова", "women", 49, 5, granddad2, gran2);
        Human papa = new Human("Радис", "Макаров", "male", 50, 6, granddad1, gran1);
        Human son1 = new Human("Виталий", "Макаров", "male", 27, 7, papa, mother1);
        Human son2 = new Human("Виктор", "Макаров", "male", 24, 8, papa, mother1);
        Human daughter1 = new Human("Александра", "Макарова", "women", 17, 9, papa, mother1);

        Tree tree = new Tree();
        tree.add(son1);
        tree.add(son2);
        tree.add(daughter1);
        tree.add(mother1);
        tree.add(gran1);
        tree.add(gran2);
        tree.add(granddad1);
        tree.add(granddad2);
        tree.add(papa);

        FileHandler fileHandler = new FileHandler();
        tree.setFileHandler(fileHandler);
        tree.save();
        Tree read = tree.read();
        System.out.println(read);

    }
}