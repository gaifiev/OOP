package home5.view;

import java.util.Scanner;

import home5.Service.FileHandler;
import home5.Service.Tree;
import home5.presenter.Presenter;

public class ConsoleUI {

    private Presenter presenter;
    private FileHandler fileHandler;
    private Tree tree;

    public ConsoleUI(Presenter presenter, FileHandler fileHandler, Tree tree) {
        this.presenter = presenter;
        this.fileHandler = fileHandler;
        this.tree = tree;
        this.tree.setFileHandler(fileHandler);
        this.tree = tree.read();
    }

    public void start() {

        System.out.println("Введите команду для операции: ");
        System.out.println("1 -> Вывести всех родней иерархии");
        System.out.println("2 -> Вывод братьев и сестер");
        System.out.println("3 -> Вывод человека по имени");
        System.out.println("4 -> Сортировка всех по имени");
        System.out.println("5 -> Сортировка всех по возрасту");
        System.out.println("6 -> Пойду спать");
        Scanner db = new Scanner(System.in, "866");
        Integer select = db.nextInt();
        if (select == 1) {
            presenter.printTree();
        } else if (select == 2) {
            presenter.getSistersAndBrothers();
        } else if (select == 3) {
            presenter.searchName("Виталий");
        } else if (select == 4) {
            presenter.sortByName();
        } else if (select == 5) {
            presenter.sortByAge();
        } else if (select == 6) {
            presenter.save();
            presenter.print();
            db.close();
        }

    }

}
