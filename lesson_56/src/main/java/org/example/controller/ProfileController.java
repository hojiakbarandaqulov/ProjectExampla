package org.example.controller;

import org.example.MyTelegramBot;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.repository.ProfileRepository;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class ProfileController {

    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public ProfileController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void createNewUser(Message message) {
        Profile profile = new Profile(message.getChatId());
        profile.setUsername(message.getFrom().getUserName());
        profile.setStep(ProfileStep.ENTER_NAME);
        profileRepository.save(profile);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Xush kelibsiz. \nIsmingizni kiriting.");
        myTelegramBot.sendMsg(sendMessage);
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());


        if (text.equals("/start")) {
            if (profile == null) {
                createNewUser(message);
            }else {
               // TODO
            }
        } else if (profile.getStep().equals(ProfileStep.ENTER_NAME)) {
            profile.setName(text);
            profile.setStep(ProfileStep.ENTER_SURNAME);

            profileRepository.update(profile);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("Familiyangizni kiriting.");
            myTelegramBot.sendMsg(sendMessage);
        } else if (profile.getStep().equals(ProfileStep.ENTER_SURNAME)) {
            profile.setSurname(text);
            profile.setStep(ProfileStep.ENTER_PHONE);

            profileRepository.update(profile);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("Raqamingizni kiriting.");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.phoneKeyboard());
            myTelegramBot.sendMsg(sendMessage);
        }

    }

    public void handle(Contact contact) {
        Profile profile = profileRepository.getProfile(contact.getUserId());
        profile.setPhone(contact.getPhoneNumber());
        profile.setStep(ProfileStep.REG_DONE);
        profileRepository.update(profile);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(contact.getUserId());
        sendMessage.setText("Welcome.");

        sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard());
        myTelegramBot.sendMsg(sendMessage);
    }
}
