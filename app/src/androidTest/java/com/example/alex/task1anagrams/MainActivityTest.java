package com.example.alex.task1anagrams;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.SpoonRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final SpoonRule spoon = new SpoonRule();
    @Rule
    public final ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testMethod() throws Exception {

        String input = "as12d ds1a qwe";
        String output = "ds12a as1d ewq";

        spoon.screenshot(activityRule.getActivity(), "start");
        onView(withId(R.id.editText_input)).perform(typeText(input));
        onView(withId(R.id.textView_output)).check(matches(withText(output)));
        spoon.screenshot(activityRule.getActivity(), "end");


    }


}