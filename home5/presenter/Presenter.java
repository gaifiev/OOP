package home5.presenter;

import java.util.List;

import home5.Service.Tree;

public class Presenter {
    private Tree tree;

    public Presenter(Tree tree) {
        this.tree = tree;
    }

    public void printTree() {
        System.out.println(tree);
    }

    public void searchName(String name) {
        System.out.println(tree.search(name));
    }

    public void sortByName() {
        tree.sortByName();
        System.out.println(tree);
    }

    public void sortByAge() {
        tree.sortByAge();
        System.out.println(tree);
    }

    public void getSistersAndBrothers() {
        List<String> brotherANDsister = tree.getSistersAndBrothers("Виталий");
        System.out.println(brotherANDsister);
    }

    public void print() {
        System.out.println("Доброй ночи=)");
    }

    public void save() {
        tree.save();
    }

}
