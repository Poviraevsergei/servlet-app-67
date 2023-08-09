package com.tms.patterns.adapter;

public class Main {
    public static void main(String[] args) {
        ISender sender = new Adapter();
        sender.send("Adapter is easy pattern! ");

    }
}
