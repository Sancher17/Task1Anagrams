package com.example.alex.task1anagrams.util;

import android.util.Log;

import com.example.alex.task1anagrams.BuildConfig;

public class Logger {

    private String logTag;

//    private boolean isLogging = BuildConfig.SHOW_LOGS; /??????
    private boolean isLogging = false;

    //конструктор
    public Logger(Class c) {
        //получаем имя класса
        logTag = c.getSimpleName();
    }

    public void log(String message) {
        if (isLogging)
            Log.d(logTag, message);
    }

    public void error(Throwable message) {
        if (isLogging)
            Log.e(logTag, message.toString());
    }
}
