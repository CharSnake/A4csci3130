package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testBusinessAdd() throws Exception {

        //I can't figure out how to get the number of items in a list view, so I can't write these tests.
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.bnumber)).perform(typeText("123456789"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText("Bob"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("55 North Ave"), ViewActions.closeSoftKeyboard());
    }
}
