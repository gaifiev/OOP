package home5.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable, Serializable {
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("home5/Service/tree.txt"))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("Сохранение в файл");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public Tree read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("home5/Service/tree.txt"))) {
            return (Tree) objectInputStream.readObject();
        } catch (Exception ex) {
            System.out.println("Ты шо поломал?");
            System.out.println(ex.getMessage());
        }
        return null;
    }

}