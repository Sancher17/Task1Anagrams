package com.example.alex.task1anagrams.util;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseWords {

    public String reverse(String input) {

        List<String> list = Arrays.asList(input.split(" "));//разделяем на слова
        String output = "";
        for (String str : list) {
            char[] strToArray = str.toCharArray(); //перегоняем буквы в список
            ArrayList<Character> listOfWords = new ArrayList<>();
            ArrayList listOfSymbols = new ArrayList();//список для букв без СИМВОЛОВ
            Map<Integer, Character> mapOfSymbols = new HashMap<>();
            for (int i = 0; i < strToArray.length; i++) {
                listOfWords.add(strToArray[i]);
                //сортируем буквы и символы
                if (listOfWords.get(i) > 96 & listOfWords.get(i) < 123) {
                    listOfSymbols.add(0, listOfWords.get(i));
                } else {
                    mapOfSymbols.put(i, listOfWords.get(i));
                }
            }
            //добавляем выброшенные символы
            if (!mapOfSymbols.isEmpty()) {
                for (Integer key : mapOfSymbols.keySet()) {
                    listOfSymbols.add(key, mapOfSymbols.get(key));
                }
            }
            output = output.concat(TextUtils.join("", listOfSymbols)).concat(" ");
        }
        return  output;
    }
}

