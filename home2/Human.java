package home2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private String lastname;
    private Integer age;
    private String gender;
    private Integer _id;
    private Human father;
    private Human mother;
    private List<Human> children;

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    /**
     * @param name     //имя
     * @param lastname //фамилия
     * @param gender   //пол
     * @param age      //возраст
     * @param father   //отец
     * @param mother   //мать
     */
    public Human(String name, String lastname, String gender, Integer age, Integer _id, Human father, Human mother) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this._id = _id;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public void RandomGen() { // метод генерирует _id, пока не генерирует
        Random _id = new Random();
        _id.setSeed(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public int compareTo(Human o) {
        return lastname.compareTo(o.lastname);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s Фамилия: %s Лет: %s Пол: %s\n", name, lastname, age, gender);
    }

}