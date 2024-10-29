package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val radioSquare = findViewById<RadioButton>(R.id.radioSquare)
        val buttonShow = findViewById<Button>(R.id.buttonShow)
        val listView = findViewById<ListView>(R.id.listView)
        val textViewError = findViewById<TextView>(R.id.textViewError)
        buttonShow.setOnClickListener {
            val input = editTextNumber.text.toString()
            textViewError.text = "" // Clear previous error

            // Validate the input
            val number = input.toIntOrNull()
            if (number == null || number <= 0) {
                textViewError.text = "Please enter a positive integer"
                return@setOnClickListener
            }

            // Get the selected option
            val numbersList = when {
                radioEven.isChecked -> getEvenNumbers(number)
                radioOdd.isChecked -> getOddNumbers(number)
                radioSquare.isChecked -> getSquareNumbers(number)
                else -> {
                    textViewError.text = "Please select an option"
                    return@setOnClickListener
                }
            }

            // Display the result in the ListView
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbersList)
            listView.adapter = adapter
        }
    }

    // Function to get even numbers from 0 to n
    private fun getEvenNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 == 0 }
    }

    // Function to get odd numbers from 1 to n
    private fun getOddNumbers(n: Int): List<Int> {
        return (1..n).filter { it % 2 != 0 }
    }

    // Function to get square numbers from 0 to n
    private fun getSquareNumbers(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        while (i * i <= n) {
            result.add(i * i)
            i++
        }
        return result
    }
}
