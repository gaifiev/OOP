package home3;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable);

    Object read();
}