package org.example;

import org.example.controller.CallBackController;
import org.example.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    private MainController mainController;
    private CallBackController callBackController;

    public MyTelegramBot() {
        mainController = new MainController(this);
        callBackController = new CallBackController(this);
    }
    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
               if (update.getMessage().getFrom().getId() ==5810436977L){
                   SendMessage sendMessage = new SendMessage();
                   sendMessage.setChatId(5810436977L);
                   sendMessage.setText("MAZGI. \uD83E\uDD0C\uD83C\uDFFF");
                   sendMsg(sendMessage);
               }
                Message message = update.getMessage();
                mainController.handle(message.getText(), message);
            } else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String data = callbackQuery.getData();
                callBackController.handle(data, (Message) callbackQuery.getMessage());
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
            throw new RuntimeException(e);
        }
    }

    public void sendMsg(SendPhoto method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "mazgi_byte_bot";
    }

    @Override
    public String getBotToken() {
        return "6736075314:AAGOB7pE7_t_Ssgz44YNOioQ9OMn8w_twdU";
    }


}
