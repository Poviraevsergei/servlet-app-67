package com.tms.patterns.adapter;

public class SmsSender implements ISender {
    @Override
    public void send(String text) {
        System.out.println("Sending sms message: " + text);
    }
}
