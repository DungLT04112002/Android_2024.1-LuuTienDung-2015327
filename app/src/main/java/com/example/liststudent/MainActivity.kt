package com.example.liststudent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

data class Student(
    val name: String,
    val studentId: String
)

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listStudentInClass: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFind = findViewById<EditText>(R.id.inputFind)
        val textViewStudent = findViewById<ListView>(R.id.listStudent)

        // Danh sách sinh viên
        listStudentInClass = listOf(
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

        // Tạo danh sách hiển thị ban đầu
        val studentFinalList = listStudentInClass.map { "${it.name} - ${it.studentId}" }
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentFinalList)
        textViewStudent.adapter = adapter

        // Thêm TextWatcher cho EditText
        inputFind.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Chỉ tìm kiếm nếu độ dài đầu vào lớn hơn hoặc bằng 2
                if (s != null && s.length >= 2) {
                    filterStudentList(s.toString())
                } else {
                    // Hiển thị toàn bộ danh sách nếu không đủ 2 ký tự
                    adapter.clear()
                    adapter.addAll(studentFinalList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Hàm lọc danh sách sinh viên dựa trên truy vấn
    private fun filterStudentList(query: String) {
        val filteredStudents = listStudentInClass.filter {
            it.name.contains(query, ignoreCase = true) || it.studentId.contains(query)
        }.map { "${it.name} - ${it.studentId}" }

        // Cập nhật adapter với danh sách đã lọc
        adapter.clear()
        adapter.addAll(filteredStudents)
    }
}
