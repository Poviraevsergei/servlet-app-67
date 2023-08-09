package com.tms.patterns.abstract_factory.domain.wood;

import com.tms.patterns.abstract_factory.domain.Bed;

public class WoodBed implements Bed {
    @Override
    public String getMaterial() {
        return "wood";
    }
}
