package com.tms.patterns.abstract_factory.factories;

import com.tms.patterns.abstract_factory.domain.Bed;
import com.tms.patterns.abstract_factory.domain.Chair;
import com.tms.patterns.abstract_factory.domain.Table;

public interface FurnitureFactory {
    Chair getChair();
    Bed getBed();
    Table getTable();
}
