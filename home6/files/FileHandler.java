package home6.files;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(serializable);
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        return objectInputStream.readObject();
    }
}