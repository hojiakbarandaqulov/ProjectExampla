package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    List<TelegramUser> users = new LinkedList<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();

            TelegramUser telegramUser = saveUser(chatId);

            if (message.hasText()) {
                String text = message.getText();
                if (text.equals("/start")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Assalomu aleykum. Ismingizni kiriting !!");
                    sendMessage.setChatId(chatId);
                    sendMsg(sendMessage);
                    telegramUser.setCurrentStep(Step.SELECT_LANG);
                } else if (telegramUser.getCurrentStep().equals(Step.SELECT_LANG)) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Familyabgizni kiriting!!");
                    sendMessage.setChatId(chatId);
                    sendMsg(sendMessage);
                    telegramUser.setCurrentStep(Step.SHARE_CONTACT);
                }
               else if (telegramUser.equals(Step.SELECT_LANG)) {
                    SendMessage sendMessage = new SendMessage();
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> keyboardRowList = new LinkedList<>();
                    KeyboardRow keyboardRow = new KeyboardRow();
                    KeyboardButton keyboardButton = new KeyboardButton();
                    keyboardButton.setText("Contact yuborish");
                    keyboardButton.setRequestContact(true);
                    keyboardRow.add(keyboardButton);
                    keyboardRowList.add(keyboardRow);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    sendMessage.setChatId(chatId);
                    sendMsg(sendMessage);
                    telegramUser.setCurrentStep(Step.SHARE_CONTACT);
                }
            }
        }
    }

    public TelegramUser saveUser(String chatId) {
        for (TelegramUser user : users) {
            if (user.getChatId().equals(chatId)) {
                return user;
            }
        }
        TelegramUser user = new TelegramUser();
        user.setChatId(chatId);
        users.add(user);
        return user;
    }

    public void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
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
