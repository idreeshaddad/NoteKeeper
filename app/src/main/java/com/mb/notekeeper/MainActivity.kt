package com.mb.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dm = DataManager()
        val adapterCourses = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                dm.courses.values.toList())
        adapterCourses.setDropDownViewResource((R.layout.support_simple_spinner_dropdown_item))


        val spinnerCourses: Spinner = findViewById(R.id.spinnerCourses)
    }
}