package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TelegramUser {
    private String currentStep;
    private String chatId;
    private String msg;
    private String fullName;
    private String selectedLang;

}
