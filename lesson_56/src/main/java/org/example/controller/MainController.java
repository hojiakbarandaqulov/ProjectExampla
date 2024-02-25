package org.example.controller;

import org.example.MyTelegramBot;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.repository.ProfileRepository;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MainController {
    private MyTelegramBot myTelegramBot;

    private ProfileRepository profileRepository;
    private ProfileController profileController;

    public MainController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
        profileController = new ProfileController(myTelegramBot);
    }

    public void handle(String text, Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());

        Profile profile = profileRepository.getProfile(message.getChatId());

        if (profile == null) {
            profileController.createNewUser(message);
            return;
        }
        if (message.hasText()){
            if (text.equals("/start") ||
                    profile.getStep().equals(ProfileStep.ENTER_NAME) ||
                    profile.getStep().equals(ProfileStep.ENTER_SURNAME)) {
                profileController.handle(text, message);
            } else if (TaskController.keyMap.containsKey(text)) {
                //task
            }
        } else if (message.hasContact()) {
            Contact contact = message.getContact();
            profileController.handle(contact);
        }


    }
}
