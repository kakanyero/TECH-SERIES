package com.example.databaseprac

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DATABASEHELPER(context: Context) : SQLiteOpenHelper(context, DB_NAME,null,){
    companion object{
        private val DB_NAME = "task"
        private val DB_VERSION = "1"
        private val ID = "id"
        private val TABLE_NAME = "taskname"
        private val TASK_DETAILS  = "taskdetails"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}