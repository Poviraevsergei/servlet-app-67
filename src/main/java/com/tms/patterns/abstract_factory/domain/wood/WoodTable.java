package com.tms.patterns.abstract_factory.domain.wood;

import com.tms.patterns.abstract_factory.domain.Table;

public class WoodTable implements Table {
    @Override
    public String getMaterial() {
        return "wood";
    }
}
