package com.tms.patterns.abstract_factory.domain.metal;

import com.tms.patterns.abstract_factory.domain.Table;

public class MetalTable implements Table {
    @Override
    public String getMaterial() {
        return "metal";
    }
}
