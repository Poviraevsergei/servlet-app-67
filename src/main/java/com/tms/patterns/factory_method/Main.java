package com.tms.patterns.factory_method;

public class Main {
    public static void main(String[] args) {
        String param = "Java";

        Course course = switch (param){
            case "Java" -> new JavaCourse();
            case "Cpp" -> new CppCourse();
            default -> throw new RuntimeException();
        };

        course.courseDescription();
    }
}
