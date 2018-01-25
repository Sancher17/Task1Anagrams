package com.example.alex.task1anagrams.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import io.michaelrocks.paranoid.Obfuscate;

import static android.content.Context.INPUT_METHOD_SERVICE;

@Obfuscate
public class ReverseWords {

    private static Logger LOGGER = new Logger(ReverseWords.class);

    private Context context;
    private static Character FIRST_LETTER = '\u0041';
    private static Character LAST_LETTER = '\u007A';
    public static String KEYBOARD = "en";

    public ReverseWords(Context context) {
        this.context = context;
    }
    //1.проверяем текущую клавиатуру
    private void checkKeyboard() {
        if (context != null) {
            LOGGER.log("checkKeyboard() called / context not null: " + context.toString());
            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null){
                InputMethodSubtype ims = imm.getCurrentInputMethodSubtype();
                String localeString = ims.getLocale();
                Locale locale = new Locale(localeString);
                KEYBOARD = locale.getLanguage();
            }
            LOGGER.log("checkKeyboard() called / KEYBOARD: " + KEYBOARD);
        } else {
            LOGGER.log("checkKeyboard() called / context null");
        }
    }

    //2.проверяем локализацию
    private void checkLocale() {
        LOGGER.log("checkLocale() called");
        if (KEYBOARD.contains("en")) {
            FIRST_LETTER = '\u0041';
            LAST_LETTER = '\u007A';
        } else if (KEYBOARD.contains("ru")) {
            FIRST_LETTER = '\u0410';
            LAST_LETTER = '\u044F';
        } else if (KEYBOARD.contains("iw_IL")) {
            FIRST_LETTER = '\u0590';
            LAST_LETTER = '\u05F4';
        } else {
            LOGGER.log("checkLocale() / nothing ");
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
            ArrayList<Character> listOfSymbols = new ArrayList<>();//список для букв без СИМВОЛОВ
            List<Integer> indexOfSymbol = new ArrayList<>();
            List<Character> valueOfSymbol = new ArrayList<>();

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
                listOfSymbols.add(indexOfSymbol.get(i), valueOfSymbol.get(i));
            }
            String out1 = "";
            for (Object str1 : listOfSymbols) {
                out1 = out1.concat(str1.toString());
            }
            output = output.concat(out1).concat(" ");
        }
        LOGGER.log("reverse() called / output text: " + output);
        return output.trim();
    }
}

