package com.tms.patterns.factory_method;

public class JavaCourse extends Course {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
