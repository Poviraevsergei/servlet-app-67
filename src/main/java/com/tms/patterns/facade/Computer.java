package com.tms.patterns.facade;

public class Computer {
   private final Power power = new Power();
   private final CdRom cdRom = new CdRom();
   private final HardDisk hardDisk = new HardDisk();

    public Power getPower() {
        return power;
    }

    public CdRom getCdRom() {
        return cdRom;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    void copyInfoFromCdDiskToHardDisk() {
        power.on();
        cdRom.open();
        cdRom.close();
        hardDisk.copy();
        hardDisk.showInfo();
        power.off();
    }
}
