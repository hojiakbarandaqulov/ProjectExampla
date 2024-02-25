package org.example.controller;

import org.example.InlineKeyBoardUtil;
import org.example.MathUtil;
import org.example.MyTelegramBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;
import java.util.Map;

public class KeyBoardController {
    private MyTelegramBot app;
    private static Map<Long,StringBuilder>map=new HashMap<>();
    public KeyBoardController(MyTelegramBot app) {
        this.app = app;
    }

    public void handleMessage(String text, Message message, User user) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(message.getChatId());
        editMessageText.setMessageId(message.getMessageId());
        StringBuilder command;

        if (map.containsKey(user.getId())) {
            command = map.get(user.getId());
        } else {
            command = new StringBuilder();
            map.put(user.getId(), command);
        }

        if (text.equals("=")) {
            Integer result = MathUtil.calculate(command.toString());
            command.append(text);
            command.append(result);
            editMessageText.setText(command.toString());
            map.put(user.getId(),new StringBuilder());
        } else {
            command.append(text);
            editMessageText.setText(command.toString());
            editMessageText.setText(command.toString());

        }
        editMessageText.setReplyMarkup(InlineKeyBoardUtil.getMenuKeyboard());
        app.sendMsg(editMessageText);
    }

}
