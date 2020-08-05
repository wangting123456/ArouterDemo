package com.example.java.fanshe.fanshe_objectinfo;

public final class Student {
    private String name;
    private int age;
    enum Gender{
        male,female
    }
    private Gender gender;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Student(String name,int age,Gender gender){
       this(name,age);
       this.gender = gender;
    }
    public Student(){

    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public Gender getGender() {
        return gender;
    }

}
