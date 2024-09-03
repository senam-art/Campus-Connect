package org.innovations.campusconnect;

public class Person {

    private String name;
    private int age;
   

    //default constructor
    public Person(){
    }
    

    //overloaded constructors
    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age){
            this.name = name;
            this.age = age;

    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    
    //Mutators
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    
}

