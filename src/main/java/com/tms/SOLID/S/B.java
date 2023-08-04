package com.tms.SOLID.S;

public class B extends BookPrinter {
    public void printTextAndAuthorInConsole() {
        System.out.printf(this.text);
        System.out.printf(this.author);
    }
}
