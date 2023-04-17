package home2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable, Serializable {
    @Override
    public void save(Serializable serializable) {
        // TODO Auto-generated method stub
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("home2/tree.txt"))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("Сохранение");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public Tree read() {
        // TODO Auto-generated method stub
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("home2/tree.txt"))) {
            return (Tree) objectInputStream.readObject();
        } catch (Exception ex) {
            System.out.println("Ты шо поломал?");
            System.out.println(ex.getMessage());
        }
        return null;
    }

}