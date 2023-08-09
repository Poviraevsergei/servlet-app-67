package com.tms.patterns.abstract_factory.domain.metal;

import com.tms.patterns.abstract_factory.domain.Bed;

public class MetalBed implements Bed {
    @Override
    public String getMaterial() {
        return "metal";
    }
}
