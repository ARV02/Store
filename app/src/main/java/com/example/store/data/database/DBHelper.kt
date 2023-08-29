package com.example.store.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.store.constants.Constants.Companion.DATABASE_NAME
import com.example.store.constants.Constants.Companion.DATABASE_VERSION
import com.example.store.constants.Constants.Companion.DESCRIPTION_COL
import com.example.store.constants.Constants.Companion.ID_COL
import com.example.store.constants.Constants.Companion.IMAGE_COL
import com.example.store.constants.Constants.Companion.PRICE_COL
import com.example.store.constants.Constants.Companion.TABLE_NAME
import com.example.store.constants.Constants.Companion.TITLE_COL

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + "( "
                + ID_COL + "INTEGER"
                + IMAGE_COL + "TEXT"
                + TITLE_COL + "TEXT"
                + DESCRIPTION_COL + "TEXT"
                +  PRICE_COL + "DOUBLE" + ") ")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addProduct(title: String, image: String, description: String, price: Double) {

    }
}