package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class TelegramBot extends TelegramLongPollingBot {
    Map<String, TelegramUser> userMap = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            TelegramUser telegramUser = saveUser(chatId);
            String text = message.getText();
            SendMessage sendMessage = new SendMessage();

            if (text.equals("/start")) {
                System.out.println("\uD83C\uDFC3\u200D♂\uFE0F \uD83C\uDFC3\u200D♂\uFE0Fgoo ");

                sendMessage.setText("Assalomu aleykum!!!\n" +
                        "Tilni tanlang. ");
                sendMessage.setChatId(chatId);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<InlineKeyboardButton> ButtonList = new LinkedList<>();

                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("\uD83C\uDDFA\uD83C\uDDFFUZ");
                button1.setCallbackData(BotLanguage.UZ.name());

                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC65\uDB40\uDC6E\uDB40\uDC67\uDB40\uDC7FENG");
                button2.setCallbackData(BotLanguage.ENG.name());

                ButtonList.add(button1);
                ButtonList.add(button2);

                List<List<InlineKeyboardButton>> tr = new ArrayList<>();
                tr.add(ButtonList);
                inlineKeyboardMarkup.setKeyboard(tr);

                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                sendMsg(sendMessage);

                telegramUser.setCurrentStep(UserStep.SELECT_LANG);
            } else if (telegramUser.equals(UserStep.SELECT_LANG)) {

            } else if (telegramUser.getCurrentStep().equals(UserStep.WRITE_MSG)) {
                telegramUser.setMsg(text);
                telegramUser.setChatId(chatId);
                if (telegramUser.getSelectedLang().equals(BotLanguage.UZ)) {

                } else if (telegramUser.getSelectedLang().equals(BotLanguage.ENG)) {
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    replyKeyboardMarkup.setSelective(true);
                    List<KeyboardRow> keyboardRowList = new LinkedList<>();
                    KeyboardRow keyboardRow = new KeyboardRow();
                    KeyboardButton keyboardButton = new KeyboardButton();

                    keyboardButton.setText("Share Contact");
                    keyboardButton.setRequestContact(true);
                    keyboardRow.add(keyboardButton);
                    keyboardRowList.add(keyboardRow);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    sendText(chatId, telegramUser.getSelectedLang().equals(BotLanguage.UZ) ? "Contactni yuboring" :
                            "Share Contact");
                    sendMsg(sendMessage);
                }
            }
        } else if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getFrom().getId().toString();
            String data = update.getCallbackQuery().getData();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            sendMessage.setChatId(chatId);

            TelegramUser telegramUser = saveUser(chatId);

            if (telegramUser.getCurrentStep().equals(UserStep.SELECT_LANG)) {
                if (data.equals(BotLanguage.UZ.name())) {
                    sendMessage.setText("Royhattan o'tishni davom ettirish uchun Ism Familyangizni kiriting \n" +
                            "Misol uchun: <b>Hojiakbar Andaqulov</b>");
                    sendMessage.setParseMode("HTML");
                    sendMessage.setChatId(chatId);
                    sendMsg(sendMessage);
                    telegramUser.setSelectedLang(BotLanguage.UZ);
                    telegramUser.setCurrentStep(UserStep.ENTER_NAME);
                } else if (data.equals(BotLanguage.ENG.name())) {
                    sendMessage.setText("Enter your First Name and Last Name to continue with Royhatt \n" +
                            "For example: <b>Hojiakbar Andaqulov</b>");
                    sendMessage.setChatId(chatId);
                    sendMessage.setParseMode("HTML");
                    sendMsg(sendMessage);
                    telegramUser.setSelectedLang(BotLanguage.ENG);
                    telegramUser.setCurrentStep(UserStep.ENTER_NAME);
                }
                telegramUser.setCurrentStep(UserStep.WRITE_MSG);
            } else if (telegramUser.getCurrentStep().equals(UserStep.ENTER_NAME)) {
                telegramUser.setFullname(data);
                StringBuilder stringBuilder = new StringBuilder();
                if (telegramUser.getSelectedLang().equals(BotLanguage.UZ)) {
                    stringBuilder.append("Sizning ismingiz:");
                    stringBuilder.append(data).append("\n");
                    stringBuilder.append("Contacttingizni yuboring");
                } else if (telegramUser.getSelectedLang().equals(BotLanguage.ENG)) {
                    stringBuilder.append("Your name: ");
                    stringBuilder.append(data).append("\n");
                    stringBuilder.append("Share your Contact");
                }
                sendMessage.setText(stringBuilder.toString());
                sendMessage.setChatId(chatId);
                sendMessage.setParseMode("HTML");
                sendMsg(sendMessage);
                // contactni so'rash uchun buttonlarni yuboring.
                telegramUser.setCurrentStep(UserStep.SHARE_CONTACT);
            }


       /* TelegramUser user = saveUser(chatId);
        if (user.getStep().equals(BotConstant.SELECT_LANG)) {
            if (data.equals(BotQuery.UZ)) {
                user.setSelectedLang(BotQuery.UZ);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Royhattan o'tishni davom ettirish uchun Ism Familyangizni kiriting \n" +
                        "Misol uchun: Hojiakbar Andaqulov");
                sendMessage.setChatId(chatId);
                sendMsg(sendMessage);
            } else if (data.equals(BotQuery.ENG)) {
                user.setSelectedLang(BotQuery.ENG);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Enter your First Name and Last Name to continue with Royhatt \n" +
                        "For example: Hojiakbar Andakulov");
                sendMessage.setChatId(chatId);
                sendMsg(sendMessage);
            }
            user.setStep(BotConstant.WRITE_MSG);
        }*/
        }
    }

    private TelegramUser saveUser(String chatId) {
        if (userMap.containsKey(chatId)) {
            return userMap.get(chatId);
        }
        TelegramUser user = new TelegramUser();
        user.setChatId(chatId);
        userMap.put(chatId, user);
        return user;
    }

    public void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendText(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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

