package com.example.liststudent

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class Student(
    val name: String,
    val studentId: String
)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewStudent = findViewById<ListView>(R.id.listStudent)
        val listStudentInClass= listOf(
            Student("Luu Tien Dung", "20215327"),
            Student("Nguyen Van A", "20210001"),
            Student("Tran Thi B", "20210002"),
            Student("Pham Van C", "20210003"),
            Student("Le Thi D", "20210004"),
            Student("Hoang Van E", "20210005"),
            Student("Nguyen Thi F", "20210006"),
            Student("Dang Van G", "20210007"),
            Student("Bui Thi H", "20210008"),
            Student("Tran Van I", "20210009"),
            Student("Pham Thi J", "20210010"),
            Student("Le Van K", "20210011"),
            Student("Nguyen Thi L", "20210012"),
            Student("Vu Van M", "20210013"),
            Student("Dao Thi N", "20210014"),
            Student("Pham Van O", "20210015"),
            Student("Tran Thi P", "20210016"),
            Student("Hoang Van Q", "20210017")
        )
        val studentFinalList=listStudentInClass.map{"${it.name}-${it.studentId}"}

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,studentFinalList)

    }
}