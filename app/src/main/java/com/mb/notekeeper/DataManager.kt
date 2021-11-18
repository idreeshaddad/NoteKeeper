package com.mb.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {

        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseId] = course
        var note = NoteInfo(course, "5 Star course", "Loved it so much. Recommend to everybody.")
        notes.add(note)

        course = CourseInfo("java_lang", "Java Fundamentals: The Java Language")
        courses[course.courseId] = course
        note = NoteInfo(course, "I want my money back", "Why are people still learning Java, it's very old dated")
        notes.add(note)

        course = CourseInfo("java_Core", "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
        note = NoteInfo(course, "Kind of dull", "It starts good but it gets boring near the middle")
        notes.add(note)
    }
}