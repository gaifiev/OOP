package home5.API;

import home5.Service.FileHandler;
import home5.Service.Human;
import home5.Service.Tree;
import home5.presenter.Presenter;
import home5.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Human gran1 = new Human("Юлия", "Макарова", "women", 80, 1, null, null);
        Human gran2 = new Human("Надежда", "Иванова", "women", 77, 2, null, null);
        Human granddad1 = new Human("Адис", "Макаров", "male", 78, 3, null, null);
        Human granddad2 = new Human("Леонид", "Иванов", "male", 79, 4, null, null);
        Human mother1 = new Human("Ольга", "Макарова", "women", 49, 5, granddad2, gran2);
        Human papa = new Human("Радис", "Макаров", "male", 50, 6, granddad1, gran1);
        Human son1 = new Human("Виталий", "Макаров", "male", 27, 7, papa, mother1);
        Human son2 = new Human("Виктор", "Макаров", "male", 24, 8, papa, mother1);
        Human daughter1 = new Human("Александра", "Макарова", "women", 17, 9, papa, mother1);

        FileHandler fileHandler = new FileHandler();

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

        Presenter presenter = new Presenter(tree);
        ConsoleUI consoleUI = new ConsoleUI(presenter, fileHandler, tree);
        consoleUI.start();
    }
}