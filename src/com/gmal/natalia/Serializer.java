package com.gmal.natalia;

import java.io.*;
import java.lang.reflect.Field;

public class Serializer {

    public static void serializerToFile(Object o, File file) throws FileNotFoundException, IllegalAccessException {
        try (PrintWriter writer = new PrintWriter(file)) {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object fieldValue = field.get(o);
                    writer.println(fieldName + ":" + fieldValue);
                }
            }
        } catch (IOException | IllegalAccessException e) {
            throw e;
        }
    }

    public static <T> T deSerializer(File file, Class<T> cls) throws IllegalAccessException, InstantiationException, IOException, NoSuchFieldException {
        T newObject = (T) cls.newInstance();
        String obj = loadFromFile(file);
        String[] nameAndValue = obj.split("[\n]");
        for (String s : nameAndValue) {
            String[] str = s.split("[:]");
            String name = str[0];
            String value = str[1];
            Field field = cls.getDeclaredField(name);
            field.setAccessible(true);
            if(field.getType().equals(int.class)){
                int n=Integer.parseInt(value,10);
                field.setInt(newObject, n);
            }else if(field.getType().equals(String.class)){
                field.set(newObject,name);
            }
        }
        return newObject;
    }

    public static String loadFromFile(File file) throws IOException {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (; (temp = br.readLine()) != null; ) {
                text += temp + "\n";
            }
        }
        return text;
    }
}
