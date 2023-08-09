package com.tms.patterns.abstract_factory.domain.wood;

import com.tms.patterns.abstract_factory.domain.Chair;

public class WoodChair implements Chair {
    @Override
    public String getMaterial() {
        return "wood";
    }
}
