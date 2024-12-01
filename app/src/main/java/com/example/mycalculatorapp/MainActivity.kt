package com.example.mycalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: EditText
    private var currentInput = ""
    private var lastOperator: String? = null
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.editTextResult)

        // Set up button clicks
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { appendNumber("7") }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { appendNumber("8") }

        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { appendNumber("9") }

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener { setOperator("+") }

        // Set up other buttons in a similar way...
    }

    private fun appendNumber(number: String) {
        currentInput += number
        resultText.setText(currentInput)
    }

    private fun setOperator(operator: String) {
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput.toDouble()
            currentInput = ""
            lastOperator = operator
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && lastOperator != null) {
            secondNumber = currentInput.toDouble()
            when (lastOperator) {
                "+" -> resultText.setText((firstNumber + secondNumber).toString())
                // Implement other operations here...
            }
            currentInput = ""
        }
    }
}
