package com.tms.patterns.decorator.skills;

import com.tms.patterns.decorator.Decorator;
import com.tms.patterns.decorator.Developer;

public class DesignDeveloper extends Decorator {
    public DesignDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void showSkill() {
        super.showSkill();
        System.out.println("I can make code design ...");
    }
}
