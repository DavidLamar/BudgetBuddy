package com.example.vincent.budgetbuddy;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * Created by Chris on 4/13/2016.
 */
@RunWith(AndroidJUnit4.class)
public class mainActivityTest {

    @Rule
    public final ActivityRule<BudgetBuddy> main = new ActivityRule<>(BudgetBuddy.class);

    @Test
    public void allDisplaysOnHomeScreenAreDisplayed() {
        onView(withId(R.id.textView3)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.textView4)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.textView5)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button3)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button11)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button12)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.totalBudget)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void addPurchaseFunctionality() {
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.textView6)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.moneyField)).perform(typeText("100.54"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("Amazon"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
  //      onView(withId(R.id.endDateField)).perform(typeText("1332106"));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.button4)).perform(click());
    }

    @Test
    public void goalsFunctionality() {
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.gasTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.gasProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.gasProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.entertainmentTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.entertainmentProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.entertainmentProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.foodTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.foodProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.foodProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.billsTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.billsProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.billsProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.shoppingTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.shoppingProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.shoppingProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.otherTextView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.otherProgressBar)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.otherProgressDisplay)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button)).perform(click());

    }

    @Test
    public void addGoalsFunctionality() {
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("75"));
        onView(withId(R.id.textView15)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.submitBudget)).perform(click());
    }

    @Test
    public void spendingFunctionality() {
        onView(withId(R.id.button11)).perform(click());
        onView(withId(R.id.graph2)).perform(click());


    }
}