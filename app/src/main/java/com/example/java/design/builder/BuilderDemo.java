package com.example.java.design.proxy.builder;

public class BuilderDemo {
    public final String name; //必选
    public final String cardID;//必选
    public int age;
    public String address;
    public String phone;
    public BuilderDemo(UserBuilder builder){
        this.name = builder.name;
        this.cardID = builder.cardID;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public static class UserBuilder{
        private final String name; //必选
        private final String cardID;//必选
        private int age;
        private String address;
        private String phone;
        public UserBuilder( String name,String cardID){
            this.name = name;
            this.cardID = cardID;
        }

        public UserBuilder age(int age){
           this.age = age;
           return this;
        }
        public UserBuilder address(String address){
            this.address = address;
            return this;
        }
        public UserBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        public BuilderDemo build(){
            return new BuilderDemo(this);
        }
    }
}
