package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
        User user=message.getFrom();

        if (message.hasText()) {

            String text=message.getText();
            if (text.equals("/start")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("KeyboardButton uchun TEST.");
                sendMessage.setChatId(update.getMessage().getChatId());

                List<KeyboardRow> buttonList = new LinkedList<>();

                KeyboardRow row_one = new KeyboardRow();
                KeyboardButton button = new KeyboardButton("Telefon nomer yuborish");
                button.setRequestContact(true);
                buttonList.add(row_one);

                ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
                replyMarkup.setKeyboard(buttonList);
                replyMarkup.setResizeKeyboard(true);

                sendMessage.setReplyMarkup(replyMarkup);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
//            System.out.println(user.getUserName() + " message " + message.getText());
//
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.setChatId(message.getChatId());
//            sendMessage.setText("O'zing mazgi. Tushindingmi <b>mazgi.</b>");
//            sendMessage.setParseMode("HTML");
//            sendMsg(sendMessage);
//        } else if (message.hasPhoto()) {
//            List<PhotoSize>photoList=message.getPhoto();
//            StringBuilder builder=new StringBuilder();
//
//            photoList.forEach(photoSize -> {
//                builder.append(photoSize.getFileId());
//                builder.append("  size = ");
//                builder.append(photoSize.getFileSize());
//                builder.append("\n");
//            });
//            PhotoSize photoSize =photoList.get(photoList.size()-1);
//            //photo
//            SendPhoto sendPhoto = new SendPhoto();
//            sendPhoto.setPhoto(new InputFile(photoSize.getFileId()));
//            sendPhoto.setChatId(message.getChatId());
//            sendPhoto.setCaption("You are mazgi.:)");
//            sendMsg(sendPhoto);
//
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.setChatId(message.getChatId());
//            sendMessage.setText(builder.toString());
//            sendMsg(sendMessage);
        }
    }

    public void sendMsg(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendMsg(SendPhoto sendPhoto){
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "mazgi_uz_bot";
    }
    @Override
    public String getBotToken() {
        return "6953077086:AAGKLZAwe-GD1sOfeKJkdj1Y4go04r4xfy8";
    }
}
