package com.tms.patterns.factory_method;

public abstract class Course {
    public Developer developer;

    public Course() {
        this.developer = createDeveloper();
    }

    void courseDescription(){
        System.out.println("You will study "+ developer.getLanguage() + " language! ");
        developer.makeCode();
    }

    public abstract Developer createDeveloper();
}
