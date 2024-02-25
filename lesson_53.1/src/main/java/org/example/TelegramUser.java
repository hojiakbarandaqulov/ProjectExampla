package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TelegramUser {
    private String chatId;
    private UserStep currentStep;
    private String msg;
    private String fullname;

    private BotLanguage selectedLang;
}
