package com.tms.patterns.abstract_factory.factories;

import com.tms.patterns.abstract_factory.domain.Bed;
import com.tms.patterns.abstract_factory.domain.Chair;
import com.tms.patterns.abstract_factory.domain.Table;
import com.tms.patterns.abstract_factory.domain.wood.WoodBed;
import com.tms.patterns.abstract_factory.domain.wood.WoodChair;
import com.tms.patterns.abstract_factory.domain.wood.WoodTable;

public class WoodFactory implements FurnitureFactory {
    @Override
    public Chair getChair() {
        return new WoodChair();
    }

    @Override
    public Bed getBed() {
        return new WoodBed();
    }

    @Override
    public Table getTable() {
        return new WoodTable();
    }
}
