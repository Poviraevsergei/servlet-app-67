package com.tms.patterns.factory_method;

public class CppCourse extends Course {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
