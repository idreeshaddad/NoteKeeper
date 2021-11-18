package com.mb.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    private var notePostion = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource((R.layout.support_simple_spinner_dropdown_item))


        val spinnerCourses: Spinner = findViewById(R.id.spinnerCourses)
        spinnerCourses.adapter = adapterCourses

        notePostion = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

        if (notePostion != POSITION_NOT_SET) {
            displayNote()
            selectTheCourseInTheSpinner()
        }


        spinnerCourses.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                notePostion = position
                displayNote()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }


    private fun displayNote() {

        val note = DataManager.notes[notePostion]
        val textNoteTitle: EditText = findViewById(R.id.textNoteTitle)
        textNoteTitle.setText(note.title)
        val textNoteText: EditText = findViewById(R.id.textNoteText)
        textNoteText.setText(note.text)
    }

    private fun selectTheCourseInTheSpinner() {

        val note = DataManager.notes[notePostion]
        val coursePosition = DataManager.courses.values.indexOf(note.course)
        val spinnerCourses: Spinner = findViewById(R.id.spinnerCourses)
        spinnerCourses.setSelection(coursePosition)
    }

}