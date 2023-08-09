package com.tms.patterns.abstract_factory;

import com.tms.patterns.abstract_factory.factories.FurnitureFactory;
import com.tms.patterns.abstract_factory.factories.MetalFactory;
import com.tms.patterns.abstract_factory.factories.WoodFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = getFabric("metal");
        System.out.println("This is your chair: " + factory.getChair().getMaterial());
        System.out.println("This is your table: " + factory.getTable().getMaterial());
        System.out.println("This is your bed: " + factory.getBed().getMaterial());
    }

    public static FurnitureFactory getFabric(String material) {
        return switch (material) {
            case "metal" -> new MetalFactory();
            default -> new WoodFactory();
        };
    }
}
