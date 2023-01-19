package home5.Service;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {
    private List<T> HumanList;
    private int index;

    public TreeIterator(List<T> HumanList) {
        this.HumanList = HumanList;
    }

    @Override
    public boolean hasNext() {

        return index < HumanList.size();
    }

    @Override
    public T next() {

        return HumanList.get(index++);
    }

}
