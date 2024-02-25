package org.example.controller;

import org.example.InlineKeyBoardUtil;
import org.example.MyTelegramBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MainController {
    public SendMessage handleMessage(String text, Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        if (text.equals("/start")) {
            System.out.println("/goo \uD83D\uDE1C\uD83D\uDE1C\uD83D\uDE1C");

            sendMessage.setText("Salom Mazgi. Jallimi? \n Hizoblagichga hush kelibsiz");
            sendMessage.setReplyMarkup(InlineKeyBoardUtil.getMenuKeyboard());
            return sendMessage;
        }
        sendMessage.setText("Do not be mazgi.");
        return sendMessage;
    }
}
