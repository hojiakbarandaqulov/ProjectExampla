package org.example.util;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class MessageUtil {
    public static SendMessage notFound(Long chatId) {
        return sendMessage(chatId, "Not found");
    }

    public static SendMessage sendMessage(Long chatId, String text) {
        return new SendMessage(String.valueOf(chatId), text);
    }
}
