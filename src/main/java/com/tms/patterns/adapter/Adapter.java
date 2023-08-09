package com.tms.patterns.adapter;

public class Adapter extends TelegramLogic implements ISender {

    @Override
    public void send(String text) {
        sendingMessageToUser(text);
    }
}

/*
public class Adapter implements ISender {
    private final TelegramLogic telegramLogic = new TelegramLogic();
    @Override
    public void send(String text) {
        telegramLogic.sendingMessageToUser(text);
    }
}
 */
