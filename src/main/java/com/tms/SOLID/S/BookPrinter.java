package com.tms.SOLID.S;

public class BookPrinter extends Book{
    public void printTextInConsole(){
        System.out.printf(this.text);
    }
}
