package com.example.calculator

import android.content.Context
import android.os.Build
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.button.MaterialButton
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun activityButtonDiscard_IsWorking() {
        scenario.onActivity {
            val btnOne = it.findViewById<MaterialButton>(R.id.btn_one)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnDiscard = it.findViewById<MaterialButton>(R.id.btn_discard)
            btnOne.performClick()
            TestCase.assertEquals("1", textViewInput.text.toString())
            btnDiscard.performClick()
            TestCase.assertEquals("", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonChangeSymbol1_IsWorking() {
        scenario.onActivity {
            val btnTwo = it.findViewById<MaterialButton>(R.id.btn_two)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnChangeSymbol = it.findViewById<MaterialButton>(R.id.btn_change_symbol)
            btnTwo.performClick()
            TestCase.assertEquals("2", textViewInput.text.toString())
            btnChangeSymbol.performClick()
            TestCase.assertEquals("-2", textViewInput.text.toString())
            btnChangeSymbol.performClick()
            TestCase.assertEquals("2", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonChangeSymbol2_IsWorking() {
        scenario.onActivity {
            val btnChangeSymbol = it.findViewById<MaterialButton>(R.id.btn_change_symbol)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnThree = it.findViewById<MaterialButton>(R.id.btn_three)
            btnChangeSymbol.performClick()
            TestCase.assertEquals("-", textViewInput.text.toString())
            btnChangeSymbol.performClick()
            TestCase.assertEquals("", textViewInput.text.toString())
            btnChangeSymbol.performClick()
            TestCase.assertEquals("-", textViewInput.text.toString())
            btnThree.performClick()
            TestCase.assertEquals("-3", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonDot1_IsWorking() {
        scenario.onActivity {
            val btnFour = it.findViewById<MaterialButton>(R.id.btn_four)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnDot = it.findViewById<MaterialButton>(R.id.btn_dot)
            val btnFive = it.findViewById<MaterialButton>(R.id.btn_five)
            btnFour.performClick()
            TestCase.assertEquals("4", textViewInput.text.toString())
            btnDot.performClick()
            TestCase.assertEquals("4.", textViewInput.text.toString())
            btnFive.performClick()
            TestCase.assertEquals("4.5", textViewInput.text.toString())
            btnDot.performClick()
            TestCase.assertEquals("4.5", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonDot2_IsWorking() {
        scenario.onActivity {
            val btnSix = it.findViewById<MaterialButton>(R.id.btn_six)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnDot = it.findViewById<MaterialButton>(R.id.btn_dot)
            btnDot.performClick()
            TestCase.assertEquals(".", textViewInput.text.toString())
            btnSix.performClick()
            TestCase.assertEquals(".6", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonPercent1_IsWorking() {
        scenario.onActivity {
            val btnSeven = it.findViewById<MaterialButton>(R.id.btn_seven)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnZero = it.findViewById<MaterialButton>(R.id.btn_zero)
            val btnPercent = it.findViewById<MaterialButton>(R.id.btn_percent)
            btnSeven.performClick()
            TestCase.assertEquals("7", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("70", textViewInput.text.toString())
            btnPercent.performClick()
            TestCase.assertEquals("70", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonPercent2_IsWorking() {
        scenario.onActivity {
            val btnEight = it.findViewById<MaterialButton>(R.id.btn_eight)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnZero = it.findViewById<MaterialButton>(R.id.btn_zero)
            val btnPercent = it.findViewById<MaterialButton>(R.id.btn_percent)
            val btnPlus = it.findViewById<MaterialButton>(R.id.btn_plus)
            btnEight.performClick()
            TestCase.assertEquals("8", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("80", textViewInput.text.toString())
            btnPlus.performClick()
            TestCase.assertEquals("80+", textViewInput.text.toString())
            btnPercent.performClick()
            TestCase.assertEquals("80+", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonPercent3_IsWorking() {
        scenario.onActivity {
            val btnNine = it.findViewById<MaterialButton>(R.id.btn_nine)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnZero = it.findViewById<MaterialButton>(R.id.btn_zero)
            val btnPercent = it.findViewById<MaterialButton>(R.id.btn_percent)
            val btnPlus = it.findViewById<MaterialButton>(R.id.btn_plus)
            val btnFive = it.findViewById<MaterialButton>(R.id.btn_five)
            btnNine.performClick()
            TestCase.assertEquals("9", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("90", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("900", textViewInput.text.toString())
            btnPlus.performClick()
            TestCase.assertEquals("900+", textViewInput.text.toString())
            btnFive.performClick()
            TestCase.assertEquals("900+5", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("900+50", textViewInput.text.toString())
            btnPercent.performClick()
            TestCase.assertEquals("900.0+450.0", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonDelete_IsWorking() {
        scenario.onActivity {
            val btnSeven = it.findViewById<MaterialButton>(R.id.btn_seven)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnZero = it.findViewById<MaterialButton>(R.id.btn_zero)
            val btnDelete = it.findViewById<MaterialButton>(R.id.btn_delete)
            btnSeven.performClick()
            TestCase.assertEquals("7", textViewInput.text.toString())
            btnZero.performClick()
            TestCase.assertEquals("70", textViewInput.text.toString())
            btnDelete.performClick()
            TestCase.assertEquals("7", textViewInput.text.toString())
        }
    }

    @Test
    fun activityButtonDivide_IsWorking() {
        scenario.onActivity {
            val btnEight = it.findViewById<MaterialButton>(R.id.btn_eight)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnTwo = it.findViewById<MaterialButton>(R.id.btn_two)
            val btnDivide = it.findViewById<MaterialButton>(R.id.btn_divide)
            val btnEquals = it.findViewById<MaterialButton>(R.id.btn_equals)
            val textViewOperations = it.findViewById<AppCompatTextView>(R.id.operations_text)
            btnEight.performClick()
            TestCase.assertEquals("8", textViewInput.text.toString())
            btnDivide.performClick()
            TestCase.assertEquals("8/", textViewInput.text.toString())
            btnTwo.performClick()
            TestCase.assertEquals("8/2", textViewInput.text.toString())
            btnEquals.performClick()
            TestCase.assertEquals("4", textViewInput.text.toString())
            TestCase.assertEquals("8/2", textViewOperations.text.toString())
        }
    }

    @Test
    fun activityButtonMultiply_IsWorking() {
        scenario.onActivity {
            val btnThree = it.findViewById<MaterialButton>(R.id.btn_three)
            val btnTwo = it.findViewById<MaterialButton>(R.id.btn_two)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnMultiply = it.findViewById<MaterialButton>(R.id.btn_multiply)
            val btnEquals = it.findViewById<MaterialButton>(R.id.btn_equals)
            val textViewOperations = it.findViewById<AppCompatTextView>(R.id.operations_text)
            btnTwo.performClick()
            TestCase.assertEquals("2", textViewInput.text.toString())
            btnMultiply.performClick()
            TestCase.assertEquals("2*", textViewInput.text.toString())
            btnThree.performClick()
            TestCase.assertEquals("2*3", textViewInput.text.toString())
            btnEquals.performClick()
            TestCase.assertEquals("6.00", textViewInput.text.toString())
            TestCase.assertEquals("2*3", textViewOperations.text.toString())
        }
    }

    @Test
    fun activityButtonMinus_IsWorking() {
        scenario.onActivity {
            val btnOne = it.findViewById<MaterialButton>(R.id.btn_one)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnThree = it.findViewById<MaterialButton>(R.id.btn_three)
            val btnMinus = it.findViewById<MaterialButton>(R.id.btn_minus)
            val btnEquals = it.findViewById<MaterialButton>(R.id.btn_equals)
            val textViewOperations = it.findViewById<AppCompatTextView>(R.id.operations_text)
            btnOne.performClick()
            TestCase.assertEquals("1", textViewInput.text.toString())
            btnMinus.performClick()
            TestCase.assertEquals("1-", textViewInput.text.toString())
            btnThree.performClick()
            TestCase.assertEquals("1-3", textViewInput.text.toString())
            btnEquals.performClick()
            TestCase.assertEquals("-2.0", textViewInput.text.toString())
            TestCase.assertEquals("1-3", textViewOperations.text.toString())
        }
    }

    @Test
    fun activityButtonPlus_IsWorking() {
        scenario.onActivity {
            val btnEight = it.findViewById<MaterialButton>(R.id.btn_eight)
            val textViewInput = it.findViewById<AppCompatEditText>(R.id.input_text)
            val btnThree = it.findViewById<MaterialButton>(R.id.btn_three)
            val btnPlus = it.findViewById<MaterialButton>(R.id.btn_plus)
            val btnEquals = it.findViewById<MaterialButton>(R.id.btn_equals)
            val textViewOperations = it.findViewById<AppCompatTextView>(R.id.operations_text)
            btnThree.performClick()
            TestCase.assertEquals("3", textViewInput.text.toString())
            btnPlus.performClick()
            TestCase.assertEquals("3+", textViewInput.text.toString())
            btnEight.performClick()
            TestCase.assertEquals("3+8", textViewInput.text.toString())
            btnEquals.performClick()
            TestCase.assertEquals("11.0", textViewInput.text.toString())
            TestCase.assertEquals("3+8", textViewOperations.text.toString())
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}