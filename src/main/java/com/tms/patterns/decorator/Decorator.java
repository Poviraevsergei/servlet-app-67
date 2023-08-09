package com.tms.patterns.decorator;

public class Decorator implements Developer {
    private final Developer developer;

    public Decorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void showSkill() {
        developer.showSkill();
    }
}
