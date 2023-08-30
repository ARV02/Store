package com.example.store.data.database

import android.content.ContentValues
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
import com.example.store.data.model.ProductsResponse
import dagger.hilt.android.qualifiers.ApplicationContext

class DBHelper(@ApplicationContext context: Context, factory: SQLiteDatabase.CursorFactory?):
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

    fun addProduct(product: ProductsResponse) {
        val values = ContentValues()

        values.put(TITLE_COL, product.title)
        values.put(IMAGE_COL, product.image)
        values.put(DESCRIPTION_COL, product.description)
        values.put(PRICE_COL, product.price)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }
}