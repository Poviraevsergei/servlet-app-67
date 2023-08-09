package com.tms.patterns.abstract_factory.domain.metal;

import com.tms.patterns.abstract_factory.domain.Chair;

public class MetalChair implements Chair {
    @Override
    public String getMaterial() {
        return "metal";
    }
}
