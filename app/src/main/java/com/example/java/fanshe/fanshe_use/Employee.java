package com.example.java.fanshe.fanshe_use;

public final class Employee {
    private String name;
    private int age;
    enum Gender{
        male,female
    }
    private Gender gender;
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Employee(String name, int age, Gender gender){
       this(name,age);
       this.gender = gender;
    }
    public Employee(){

    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

}
