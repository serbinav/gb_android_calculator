package com.example.calculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun allNumbers_Click() {
        onView(withId(R.id.btn_one)).perform(click())
        onView(withId(R.id.btn_two)).perform(click())
        onView(withId(R.id.btn_three)).perform(click())
        onView(withId(R.id.btn_four)).perform(click())
        onView(withId(R.id.btn_five)).perform(click())
        onView(withId(R.id.btn_six)).perform(click())
        onView(withId(R.id.btn_seven)).perform(click())
        onView(withId(R.id.btn_eight)).perform(click())
        onView(withId(R.id.btn_nine)).perform(click())
        onView(withId(R.id.btn_zero)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("1234567890")))
    }

    @Test
    fun allBtn_CheckText() {
        onView(withId(R.id.btn_one)).check(matches(withText(TestUtils.getString(R.string.one))))
        onView(withId(R.id.btn_two)).check(matches(withText(TestUtils.getString(R.string.two))))
        onView(withId(R.id.btn_three)).check(matches(withText(TestUtils.getString(R.string.three))))
        onView(withId(R.id.btn_four)).check(matches(withText(TestUtils.getString(R.string.four))))
        onView(withId(R.id.btn_five)).check(matches(withText(TestUtils.getString(R.string.five))))
        onView(withId(R.id.btn_six)).check(matches(withText(TestUtils.getString(R.string.six))))
        onView(withId(R.id.btn_seven)).check(matches(withText(TestUtils.getString(R.string.seven))))
        onView(withId(R.id.btn_eight)).check(matches(withText(TestUtils.getString(R.string.eight))))
        onView(withId(R.id.btn_nine)).check(matches(withText(TestUtils.getString(R.string.nine))))
        onView(withId(R.id.btn_zero)).check(matches(withText(TestUtils.getString(R.string.zero))))

        onView(withId(R.id.btn_discard)).check(matches(withText(TestUtils.getString(R.string.discard))))
        onView(withId(R.id.btn_change_symbol)).check(matches(withText(TestUtils.getString(R.string.change_symbol))))
        onView(withId(R.id.btn_percent)).check(matches(withText(TestUtils.getString(R.string.percent))))
        onView(withId(R.id.btn_delete)).check(matches(withText(TestUtils.getString(R.string.delete))))
        onView(withId(R.id.btn_divide)).check(matches(withText(TestUtils.getString(R.string.divide))))
        onView(withId(R.id.btn_multiply)).check(matches(withText(TestUtils.getString(R.string.multiply))))
        onView(withId(R.id.btn_minus)).check(matches(withText(TestUtils.getString(R.string.minus))))
        onView(withId(R.id.btn_dot)).check(matches(withText(TestUtils.getString(R.string.dot))))
        onView(withId(R.id.btn_equals)).check(matches(withText(TestUtils.getString(R.string.equals))))
        onView(withId(R.id.btn_plus)).check(matches(withText(TestUtils.getString(R.string.plus))))
    }

    @Test
    fun title_Click() {
        onView(withId(R.id.title)).perform(click())

        onView(withId(R.id.first_themes)).check(matches((isDisplayed())))
        onView(withId(R.id.first_themes)).check(matches(withText(TestUtils.getString(R.string.one_themes))))
        onView(withId(R.id.second_themes)).check(matches((isDisplayed())))
        onView(withId(R.id.second_themes)).check(matches(withText(TestUtils.getString(R.string.two_themes))))
        onView(withId(R.id.third_themes)).check(matches((isDisplayed())))
        onView(withId(R.id.third_themes)).check(matches(withText(TestUtils.getString(R.string.three_themes))))
    }

    @Test
    fun btnDiscard_Click() {
        onView(withId(R.id.btn_nine)).perform(click())
        onView(withId(R.id.btn_one)).perform(click())
        onView(withId(R.id.btn_one)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("911")))
        onView(withId(R.id.btn_discard)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("")))
    }

    @Test
    fun btnDelete_Click() {
        onView(withId(R.id.btn_one)).perform(click())
        onView(withId(R.id.btn_one)).perform(click())
        onView(withId(R.id.btn_two)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("112")))
        onView(withId(R.id.btn_delete)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("11")))
    }

    @Test
    fun btnChangeSymbol_Click() {
        onView(withId(R.id.btn_three)).perform(click())
        onView(withId(R.id.btn_change_symbol)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("-3")))
        onView(withId(R.id.btn_change_symbol)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("3")))
    }

    @Test
    fun btnDot_Click() {
        onView(withId(R.id.btn_four)).perform(click())
        onView(withId(R.id.btn_dot)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("4.")))
        onView(withId(R.id.btn_five)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("4.5")))
    }

    @Test
    fun btnPercent_Click() {
        onView(withId(R.id.btn_two)).perform(click())
        onView(withId(R.id.btn_zero)).perform(click())
        onView(withId(R.id.btn_zero)).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("200+")))
        onView(withId(R.id.btn_five)).perform(click())
        onView(withId(R.id.btn_zero)).perform(click())
        onView(withId(R.id.btn_percent)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("200.0+100.0")))
    }

    @Test
    fun btnDivide_Click() {
        onView(withId(R.id.btn_six)).perform(click())
        onView(withId(R.id.btn_divide)).perform(click())
        onView(withId(R.id.btn_two)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("6/2")))
        onView(withId(R.id.btn_equals)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("3")))
        onView(withId(R.id.operations_text)).check(matches(withText("6/2")))
    }

    @Test
    fun btnMultiply_Click() {
        onView(withId(R.id.btn_seven)).perform(click())
        onView(withId(R.id.btn_multiply)).perform(click())
        onView(withId(R.id.btn_three)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("7*3")))
        onView(withId(R.id.btn_equals)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("21.00")))
        onView(withId(R.id.operations_text)).check(matches(withText("7*3")))
    }

    @Test
    fun btnMinus_Click() {
        onView(withId(R.id.btn_nine)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_eight)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("9-8")))
        onView(withId(R.id.btn_equals)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("1.0")))
        onView(withId(R.id.operations_text)).check(matches(withText("9-8")))
    }

    @Test
    fun btnPlus_Click() {
        onView(withId(R.id.btn_five)).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(withId(R.id.btn_five)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("5+5")))
        onView(withId(R.id.btn_equals)).perform(click())
        onView(withId(R.id.input_text)).check(matches(withText("10.0")))
        onView(withId(R.id.operations_text)).check(matches(withText("5+5")))
    }

    @After
    fun close() {
        scenario.close()
    }
}