package com.gmal.natalia;

import java.io.*;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Murka", "red", 3);

        File file = new File("cat.txt");
        Serializer.serializerToFile(cat, file);

        Cat cat2 = null;
        try {
            cat2 = Serializer.deSerializer(file, Cat.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(cat2);
    }
}
