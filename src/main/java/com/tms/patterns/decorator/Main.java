package com.tms.patterns.decorator;


import com.tms.patterns.decorator.skills.DesignDeveloper;
import com.tms.patterns.decorator.skills.HibernateDeveloper;
import com.tms.patterns.decorator.skills.SpringDeveloper;
import com.tms.patterns.decorator.skills.TestDeveloper;

public class Main {
    public static void main(String[] args) {
        JavaDeveloper javaDeveloper = new JavaDeveloper();

        SpringDeveloper springDeveloper = new SpringDeveloper(javaDeveloper);
        HibernateDeveloper hibernateDeveloper = new HibernateDeveloper(springDeveloper);
        DesignDeveloper designDeveloper = new DesignDeveloper(hibernateDeveloper);
        TestDeveloper testDeveloper = new TestDeveloper(designDeveloper);

        testDeveloper.showSkill();

        System.out.println("------------");
        CppDeveloper cppDeveloperSecond = new CppDeveloper();
        DesignDeveloper cppDesignDeveloperSecond = new DesignDeveloper(cppDeveloperSecond);
        cppDesignDeveloperSecond.showSkill();
    }
}
