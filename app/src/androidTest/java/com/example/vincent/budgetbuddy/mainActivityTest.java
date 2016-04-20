package com.example.vincent.budgetbuddy;

import android.content.ClipData;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
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
        onView(withId(R.id.button2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button3)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button11)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.button12)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.totalBudget)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void addPurchaseShopping() {
        //Add Shopping purchase
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.textView6)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.moneyField)).perform(typeText("100.54"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("Amazon"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Shopping"))).perform(click());
        onView(withId(R.id.button4)).perform(click());
    }
        @Test
        public void addPurchaseGas() {
            //Add Gas purchase
            onView(withId(R.id.button12)).perform(click());
            onView(withId(R.id.moneyField)).perform(typeText("25.36"));
            onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
            onView(withId(R.id.placeField)).perform(typeText("Speedway"));
            onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
            onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
            onView(withId(R.id.purchaseType)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
            onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
            onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
            onView(withId(R.id.categorySpinner)).perform(click());
            onData(allOf(is(instanceOf(String.class)), is("Gas"))).perform(click());
            onView(withId(R.id.button4)).perform(click());
        }
    @Test
    public void addPurchaseFood() {
        //Add Food purchase
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.moneyField)).perform(typeText("52.69"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("FamilyFare"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(3).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Food"))).perform(click());
        onView(withId(R.id.button4)).perform(click());
    }
    @Test
    public void addPurchaseBills() {
        //Add Bills purchase
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.moneyField)).perform(typeText("34.89"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("DTE"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Bills"))).perform(click());
        onView(withId(R.id.categorySpinner)).check(matches(withSpinnerText(containsString("Bills"))));
        onView(withId(R.id.button4)).perform(click());
    }
    @Test
    public void addPurchaseEntertainment() {
        //Add Entertainment purchase
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.moneyField)).perform(typeText("18.23"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("Celebration Cinema"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Entertainment"))).perform(click());
        onView(withId(R.id.button4)).perform(click());
    }
    @Test
    public void addPurchaseOther() {
        //Add Other purchase
        onView(withId(R.id.button12)).perform(click());
        onView(withId(R.id.moneyField)).perform(typeText("15"));
        onView(withId(R.id.textView7)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.placeField)).perform(typeText("Pay Sister back"));
        onView(withId(R.id.textView8)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.purchaseType)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.textView9)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categoryOfPurchase)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.categorySpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Other"))).perform(click());
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
        onView(withId(R.id.otherProgressDisplay)).equals(75);

        onView(withId(R.id.button)).perform(click());

    }

    @Test
    public void addGoalsFunctionality() {
        // Entertainment Budget
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("75"));
        onView(withId(R.id.submitBudget)).perform(click());
        // Gas Budget
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("125"));
        onView(withId(R.id.submitBudget)).perform(click());
        // Food Budget
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("65"));
        onView(withId(R.id.submitBudget)).perform(click());
        // Bills Budget
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(3).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("500"));
        onView(withId(R.id.submitBudget)).perform(click());
        // Shopping Budget
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(4).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("126"));
        onView(withId(R.id.submitBudget)).perform(click());
        // Other Budget
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(5).perform(click());
        onView(withId(R.id.textView14)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.amountField)).perform(typeText("50"));
        onView(withId(R.id.submitBudget)).perform(click());
    }

    @Test
     public void spendingFunctionality() {
        onView(withId(R.id.button11)).perform(click());
        onView(withId(R.id.graph2)).perform(click());
        onView(withId(R.id.chart2)).perform(click());
    }
}