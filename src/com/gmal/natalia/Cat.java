package com.gmal.natalia;

import java.io.Serializable;

public class Cat implements Serializable {
    @Save
    private String name;
    @Save
    private String colour;
    private int age;

    public Cat(String name, String colour, int age) {
        this.name = name;
        this.colour = colour;
        this.age = age;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", age=" + age +
                '}';
    }
}
