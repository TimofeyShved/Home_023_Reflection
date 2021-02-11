package com.company;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass(); // Создаем переменный типа класс, указывая к нему доступ
        Class clss = someClass.getClass(); // подобное
        Class clss2 = SomeClass.class; //подобное
        Class clss3 = Class.forName("com.company.SomeClass"); // подобное
        SomeClass someClass1 = (SomeClass) clss.newInstance();

        System.out.println("------Путь-----");
        System.out.println(clss.getName()); // Название(Путь) класса

        System.out.println("------Constructor-----");
        Constructor[] constructors = clss.getDeclaredConstructors(); //Создаем переменную, с данными о кнструкторе класса
        for (Constructor constructor : constructors) { // цикл по ним
            System.out.println(constructor.getName()); // имя конструктора
            Parameter[] parameters = constructor.getParameters(); // входные параметры
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName()); // название параметра (и да всегда кривое) arg0, arg1, arg2... argN
                System.out.println(parameter.getType().getName()); // и его тип
            }
        }

        System.out.println("-------Method------");
        Method[] methods = clss.getDeclaredMethods();  //Создаем переменную, с данными о методах класса
        for (Method method:methods){ // цикл по ним
            System.out.println(method.getName()); // имя метода
            Parameter[] parameters = method.getParameters(); // входные параметры
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName()); // название параметра
                System.out.println(parameter.getType().getName()); // и его тип
            }
            System.out.println(Modifier.toString(method.getModifiers())); // тип доступа
            System.out.println(method.getReturnType().getName()); // и его тип Return
            method.setAccessible(true); // откроет доступ, если он private
            method.invoke(someClass, "test"); // запустить метод
        }

        System.out.println("-------Field------");
        Field[] fields = clss.getDeclaredFields(); //Создаем переменную, с данными об объектах класса
        for (Field field:fields){ // цикл по ним
            System.out.println(field.getName()); // имя объекта
            System.out.println(field.getType().getName()); // и его тип
            System.out.println(Modifier.toString(field.getModifiers())); // тип доступа
            field.setAccessible(true); // откроет доступ, если он private
            System.out.println(field.getInt(someClass)); //выведет содержимое переменной
            field.setInt(someClass, 5); // запустить метод
            System.out.println(field.getInt(someClass));
        }
    }
}



// Не известный класс
class SomeClass{
    private int i;
    //String s;

    public SomeClass(){

    }

    SomeClass(String s){
        //this.s = s;
    }

    public String someMethod(String s){
        System.out.println("This is "+s);
        return s;
    }
}
