package com.tms.patterns.abstract_factory.factories;

import com.tms.patterns.abstract_factory.domain.Bed;
import com.tms.patterns.abstract_factory.domain.Chair;
import com.tms.patterns.abstract_factory.domain.metal.MetalBed;
import com.tms.patterns.abstract_factory.domain.metal.MetalChair;
import com.tms.patterns.abstract_factory.domain.metal.MetalTable;
import com.tms.patterns.abstract_factory.domain.Table;

public class MetalFactory implements FurnitureFactory {
    @Override
    public Chair getChair() {
        return new MetalChair();
    }

    @Override
    public Bed getBed() {
        return new MetalBed();
    }

    @Override
    public Table getTable() {
        return new MetalTable();
    }
}
