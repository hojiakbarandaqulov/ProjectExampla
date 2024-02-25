package org.example;

import org.example.controller.KeyBoardController;
import org.example.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {
    private MainController mainController = new MainController();
    private KeyBoardController keyBoardController;
    public MyTelegramBot(){
        keyBoardController=new KeyBoardController(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                SendMessage sendMessage = mainController.handleMessage(message.getText(), message);
                sendMsg(sendMessage);
                return;
            } else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String text = callbackQuery.getData();
                keyBoardController.handleMessage(text, (Message) callbackQuery.getMessage(), callbackQuery.getFrom());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(SendMessage method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMsg(EditMessageText method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
          e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "calculyator_uz_bot";
    }

    @Override
    public String getBotToken() {
        return "6801156323:AAFNkpVFFq8tm5wJpO7kt5QEkcM1md9HpDk";
    }

}
