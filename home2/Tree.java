package home2;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Serializable;

public class Tree implements Serializable {
    private List<Human> members;

    private Writable writable;

    public Tree(List<Human> members) {
        this.members = members;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public void add(Human member) {
        if (member != null) {
            members.add(member);
            if (member.getFather() != null) {
                member.getFather().getChildren().add(member);
            }
            if (member.getMother() != null) {
                member.getMother().getChildren().add(member);
            }
        }
    }

    public Human search(String searchName) {
        Human find = null;
        for (Human human : members) {
            if (human.getName().contains(searchName)) {
                find = human;
            }
        }
        return find;
    }

    public List<String> getSistersAndBrothers(String seaName) {
        List<String> allNames = new ArrayList<>();
        Human find = search(seaName);
        if (find.getFather() != null && find.getFather().getChildren() != null) {
            for (Human child : find.getFather().getChildren()) {
                allNames.add(child.getName());
            }
        }
        if (find.getMother() != null && find.getMother().getChildren() != null) {
            for (Human child : find.getMother().getChildren()) {
                allNames.add(child.getName());
            }
        }
        Set<String> iterationame = new HashSet<>(allNames);
        List<String> res = new ArrayList<>(iterationame);
        res.remove(seaName);
        if (res.isEmpty()) {
            res.add("Нет братьев или сестер");
        }
        return res;
    }

    @Override
    public String toString() {
        return "Tree: " +
                members;
    }

    public void setFileHandler(Writable writable) {
        this.writable = writable;
    }

    public void save() {

        writable.save(this);

    }

    public Tree read() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                return (Tree) writable.read();
            }
        }
        return null;
    }

}
