package com.example.alex.task1anagrams.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;

import com.example.alex.task1anagrams.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Locale;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.example.alex.task1anagrams.util.ReverseWords.KEYBOARD;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ReverseWordsTest {

    @Mock
    private ReverseWords reverseWords;

    @Mock
    private Context mockContext;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockContext = Mockito.mock(Context.class);
        reverseWords = new ReverseWords(mockContext);
    }

    @Test
    public void reverseEnglish() throws Exception {
        KEYBOARD = "en";
        assertEquals("asd", reverseWords.reverse("dsa"));
        assertEquals("as4d", reverseWords.reverse("ds4a"));
        assertEquals("as4d qwe8rty", reverseWords.reverse("ds4a ytr8ewq"));
    }

    @Test
    public void reverseRussian() throws Exception {
        KEYBOARD = "ru";
        assertEquals("фыва", reverseWords.reverse("авыф"));
        assertEquals("фы2ва", reverseWords.reverse("ав2ыф"));
        assertEquals("*фы2ва яч2с!", reverseWords.reverse("*ав2ыф сч2я!"));
    }

    @Test
    public void reverseJewish() throws Exception {
        KEYBOARD = "iw_IL";
        assertEquals("בית", reverseWords.reverse("תיב"));
        assertEquals("4בית בית1", reverseWords.reverse("4תיב תיב1"));
    }

    @Test
    public void reverseNotSupportLanguage() throws Exception {
        KEYBOARD = " ";
        assertEquals("фыва", reverseWords.reverse("фыва"));
        assertEquals("фы2ва", reverseWords.reverse("фы2ва"));
        assertEquals("*фы2ва яч2с!", reverseWords.reverse("*фы2ва яч2с!"));
    }
}