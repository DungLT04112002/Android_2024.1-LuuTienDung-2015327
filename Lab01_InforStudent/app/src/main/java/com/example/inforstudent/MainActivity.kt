package com.example.formexample

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputMSSV: EditText
    private lateinit var inputName: EditText
    private lateinit var radioGenderGroup: RadioGroup
    private lateinit var inputEmail: EditText
    private lateinit var inputPhone: EditText
    private lateinit var calendarView: CalendarView
    private lateinit var buttonShowCalendar: Button
    private lateinit var spinnerWard: Spinner
    private lateinit var spinnerDistrict: Spinner
    private lateinit var spinnerCity: Spinner
    private lateinit var checkBoxSports: CheckBox
    private lateinit var checkBoxMovies: CheckBox
    private lateinit var checkBoxMusic: CheckBox
    private lateinit var checkBoxTerms: CheckBox
    private lateinit var buttonSubmit: Button
    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputMSSV = findViewById(R.id.inputMSSV)
        inputName = findViewById(R.id.inputName)
        radioGenderGroup = findViewById(R.id.radioGenderGroup)
        inputEmail = findViewById(R.id.inputEmail)
        inputPhone = findViewById(R.id.inputPhone)
        calendarView = findViewById(R.id.calendarView)
        buttonShowCalendar = findViewById(R.id.buttonShowCalendar)
        spinnerWard = findViewById(R.id.spinnerWard)
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerCity = findViewById(R.id.spinnerCity)
        checkBoxSports = findViewById(R.id.checkBoxSports)
        checkBoxMovies = findViewById(R.id.checkBoxMovies)
        checkBoxMusic = findViewById(R.id.checkBoxMusic)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        calendarView.visibility = View.GONE

        buttonShowCalendar.setOnClickListener {
            calendarView.visibility = if (calendarView.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
            calendarView.visibility = View.GONE
        }

        buttonSubmit.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val mssv = inputMSSV.text.toString()
        val name = inputName.text.toString()
        val selectedGenderId = radioGenderGroup.checkedRadioButtonId
        val email = inputEmail.text.toString()
        val phone = inputPhone.text.toString()
        val termsAccepted = checkBoxTerms.isChecked

        if (mssv.isEmpty() || name.isEmpty() || selectedGenderId == -1 ||
            email.isEmpty() || phone.isEmpty() || selectedDate.isEmpty() ||
            spinnerWard.selectedItem == null || spinnerDistrict.selectedItem == null ||
            spinnerCity.selectedItem == null || !termsAccepted) {

            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
        } else {
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()
            val hobbies = mutableListOf<String>()
            if (checkBoxSports.isChecked) hobbies.add("Thể thao")
            if (checkBoxMovies.isChecked) hobbies.add("Điện ảnh")
            if (checkBoxMusic.isChecked) hobbies.add("Âm nhạc")

            // Hiển thị thông báo thành công
            Toast.makeText(this, "Thông tin đã được nộp!", Toast.LENGTH_SHORT).show()
        }
    }
}
