package com.example.gmailview

import EmailAdapter
import EmailItem
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private lateinit var emailList: List<EmailItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        emailList = listOf(
            EmailItem("Sender 1", "05 thg 06", "Email Title 1", "Email content goes here.", false, false),
            EmailItem("Sender 2", "02 thg 10", "Email Title 2", "Another email content.", true, true),
            EmailItem("Sender 3", "03 thg 11", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 4", "03 thg 10", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 5", "07 thg 10", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 6", "12 thg 2", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 7", "11 thg 10", "Email Title 1", "Email content goes here.", false, false),
            EmailItem("Sender 8", "18 thg 01", "Email Title 2", "Another email content.", true, true),
            EmailItem("Sender 9", "02 thg 12", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 10", "03 thg 11", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 11", "04 thg 12", "Email Title 3", "More content to read.", false, false),
            EmailItem("Sender 12", "23 thg 10", "Email Title 3", "More content to read.", false, false)


        )

        emailAdapter = EmailAdapter(emailList)
        recyclerView.adapter = emailAdapter
    }
}
