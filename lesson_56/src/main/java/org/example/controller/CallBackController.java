package org.example.controller;

import org.example.MyTelegramBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class CallBackController {
    private MyTelegramBot myTelegramBot;

    public CallBackController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
    }

    public void handle(String text, Message message) {
    }

}
