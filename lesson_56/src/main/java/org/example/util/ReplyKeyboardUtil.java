package org.example.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class ReplyKeyboardUtil {

    public static KeyboardButton button(String text) {
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static ReplyKeyboardMarkup phoneKeyboard() {
        KeyboardButton button = new KeyboardButton();
        button.setText("Kontact jo'natish");
        button.setRequestContact(true);

        KeyboardRow row = new KeyboardRow();
        row.add(button);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }


    public static ReplyKeyboardMarkup menuKeyboard() {
        KeyboardButton taskList = button("Task List");
        KeyboardButton addTask = button("Add List");
        KeyboardButton weather = button("Weather List");
        KeyboardButton currency = button("Currency List");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(taskList);
        row1.add(addTask);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(weather);
        row2.add(currency);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row1);
        rowList.add(row2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }



   /* public static ReplyKeyboardMarkup Location() {
        KeyboardButton button1 = KeyButtonUtil.keyButton("No");
        KeyboardButton button2 = KeyButtonUtil.keyButton("Yes");
        KeyboardButton button3 = KeyButtonUtil.keyButton("Back to location menu", ":arrow_left:");
        KeyboardRow keyboardRow1 = KeyButtonUtil.keyRow(button1, button2);
        KeyboardRow keyboardRow2 = KeyButtonUtil.keyRow(button3);
        List<KeyboardRow> keyboardRowList = KeyButtonUtil.keyboardRowList(keyboardRow1, keyboardRow2);
        return KeyButtonUtil.replyKeyboardMarkup(keyboardRowList);
    }*/

 /*   public static ReplyKeyboardMarkup replyKeyboardMarkup(List<KeyboardRow> keyboardRowList) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }*/

/*    public static KeyboardRow keyRow(KeyboardButton... keyboardButton) {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.addAll(Arrays.asList(keyboardButton));
        return keyboardRow;

    }*/

}
