package com.tms.patterns.decorator.skills;

import com.tms.patterns.decorator.Decorator;
import com.tms.patterns.decorator.Developer;

public class SpringDeveloper extends Decorator {
    public SpringDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void showSkill() {
        super.showSkill();
        System.out.println("We can make some work with Spring ...");
    }
}
