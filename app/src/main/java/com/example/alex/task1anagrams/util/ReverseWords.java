package com.example.alex.task1anagrams.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Toast;

import com.example.alex.task1anagrams.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ReverseWords {

    private static Logger LOGGER = new Logger(ReverseWords.class);

    Context context;
    private static Character FIRST_LETTER = '\u0041';
    private static Character LAST_LETTER = '\u007A';
    public static String KEYBOARD = "en";

    public ReverseWords (Context context){
        this.context = context;
    }

    //проверяем локализацию
    public void checkLocale() {
        LOGGER.log("checkLocale() called");
        if (KEYBOARD.contains("en")) {
            FIRST_LETTER = '\u0041';
            LAST_LETTER = '\u007A';
        } else if (KEYBOARD.contains("ru")) {
            FIRST_LETTER = '\u0410';
            LAST_LETTER = '\u044F';
        } else if (KEYBOARD.contains("iw_IL")) {
            FIRST_LETTER = '\u05D0';
            LAST_LETTER = '\u05EA';
        } else {
            LOGGER.log("checkLocale() / nothing ");
            String toast = context.getString(R.string.selected_lang);
            Toast.makeText(context,toast , Toast.LENGTH_LONG).show();
        }
    }

    //проверяем текущую клавиатуру
    public void checkKeyboard() {
        if (context != null){
            LOGGER.log("checkKeyboard() called / context not null: "+context.toString());
            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            InputMethodSubtype ims = imm.getCurrentInputMethodSubtype();
            String localeString = ims.getLocale();
            Locale locale = new Locale(localeString);
            KEYBOARD = locale.getLanguage();
            LOGGER.log("checkKeyboard() called / KEYBOARD: " + KEYBOARD);
        }else {
            LOGGER.log("checkKeyboard() called / context null");
        }
    }

    //преобразовываем текст
    public String reverse(String input) {
        LOGGER.log("reverse() called / input text: " + input);
        checkKeyboard();
        checkLocale();
        List<String> list = Arrays.asList(input.split(" "));//разделяем на слова
        String output = "";
        for (String str : list) {
            char[] strToArray = str.toCharArray(); //перегоняем буквы в список
            ArrayList<Character> listOfWords = new ArrayList<>();
            ArrayList listOfSymbols = new ArrayList();//список для букв без СИМВОЛОВ
            List indexOfSymbol = new ArrayList();
            List valueOfSymbol = new ArrayList();

            for (int i = 0; i < strToArray.length; i++) {
                listOfWords.add(strToArray[i]);
                //сортируем буквы и символы
                if (listOfWords.get(i) >= FIRST_LETTER & listOfWords.get(i) <= LAST_LETTER) {
                    listOfSymbols.add(0, listOfWords.get(i));
                } else {
                    indexOfSymbol.add(i);
                    valueOfSymbol.add(listOfWords.get(i));
                }
            }
            //добавляем выброшенные символы - новая реализация
            for (int i = 0; i < indexOfSymbol.size(); i++) {
                listOfSymbols.add((Integer) indexOfSymbol.get(i), valueOfSymbol.get(i));
            }
            String out1 = "";
            for (Object str1 : listOfSymbols) {
                out1 = out1.concat(str1.toString());
            }
            output = output.concat(out1).concat(" ");
        }
        LOGGER.log("reverse() called / output text: " + output);
        return output;
    }
}

