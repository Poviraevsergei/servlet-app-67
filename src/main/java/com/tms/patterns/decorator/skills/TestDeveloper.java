package com.tms.patterns.decorator.skills;

import com.tms.patterns.decorator.Decorator;
import com.tms.patterns.decorator.Developer;

public class TestDeveloper extends Decorator {
    public TestDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void showSkill() {
        super.showSkill();
        System.out.println("Can write come tests ...");
    }
}