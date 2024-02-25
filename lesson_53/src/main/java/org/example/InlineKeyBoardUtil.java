package org.example;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class InlineKeyBoardUtil {
    public static InlineKeyboardButton button(String text, String callBack) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callBack);
        return button;
    }

    public static InlineKeyboardMarkup getMenuKeyboard() {
        InlineKeyboardButton button7 = InlineKeyBoardUtil.button("7", "7");
        InlineKeyboardButton button8 = InlineKeyBoardUtil.button("8", "8");
        InlineKeyboardButton button9 = InlineKeyBoardUtil.button("9", "9");

        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(button7);
        row1.add(button8);
        row1.add(button9);
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        InlineKeyboardButton button4 = InlineKeyBoardUtil.button("4", "4");
        InlineKeyboardButton button5 = InlineKeyBoardUtil.button("5", "5");
        InlineKeyboardButton button6 = InlineKeyBoardUtil.button("6", "6");
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);

        List<InlineKeyboardButton> row3 = new LinkedList<>();
        InlineKeyboardButton button1 = InlineKeyBoardUtil.button("1", "1");
        InlineKeyboardButton button2 = InlineKeyBoardUtil.button("2", "2");
        InlineKeyboardButton button3 = InlineKeyBoardUtil.button("3", "3");

        row3.add(button1);
        row3.add(button2);
        row3.add(button3);

        List<InlineKeyboardButton> row4 = new LinkedList<>();
        InlineKeyboardButton Qoshish = InlineKeyBoardUtil.button("+", "+");
        InlineKeyboardButton Ayrish = InlineKeyBoardUtil.button("-", "-");
        InlineKeyboardButton Kopaytirish = InlineKeyBoardUtil.button("*", "*");
        InlineKeyboardButton Bolish = InlineKeyBoardUtil.button("/", "/");
        row4.add(Qoshish);
        row4.add(Ayrish);
        row4.add(Kopaytirish);
        row4.add(Bolish);
        List<InlineKeyboardButton> row5 = new LinkedList<>();
        InlineKeyboardButton teng = InlineKeyBoardUtil.button("=", "=");
        row5.add(teng);

        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
