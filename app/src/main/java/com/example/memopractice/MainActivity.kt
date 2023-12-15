package com.example.memopractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val memoList = ArrayList<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MemoDBHelper(this)
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            MemoDBHelper.TABLE_NAME,
            arrayOf(MemoDBHelper.COLUMN_ID, MemoDBHelper.COLUMN_TITLE, MemoDBHelper.COLUMN_CONTENT, MemoDBHelper.COLUMN_TIMESTAMP),
            null,
            null,
            null,
            null,
            "${MemoDBHelper.COLUMN_TIMESTAMP} DESC"
        )

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(MemoDBHelper.COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(MemoDBHelper.COLUMN_TITLE))
            val content = cursor.getString(cursor.getColumnIndexOrThrow(MemoDBHelper.COLUMN_CONTENT))
            val timestamp = cursor.getLong(cursor.getColumnIndexOrThrow(MemoDBHelper.COLUMN_TIMESTAMP))

            val memo = Memo(id, title, content, timestamp)
            memoList.add(memo)
        }

        cursor.close()
    }
}