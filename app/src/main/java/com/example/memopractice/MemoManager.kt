package com.example.memopractice

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class MemoManager {
    private val memos = mutableListOf<Memo>()
    private val file = File("memos.txt")


    init {
        loadMemos()
    }
    fun add(memo: Memo) {
        memos.add(memo)
        saveMemos()
    }

    fun list(): List<Memo> {
        return memos
    }

    fun get(index: Int): Memo? {
        return memos.getOrNull(index)
    }

    fun update(index: Int, memo: Memo): Boolean {
        return memos.getOrNull(index)?.let {
            memos[index] = memo
            true
        } ?: false
    }

    fun remove(index: Int): Boolean {
        return memos.getOrNull(index)?.let {
            memos.removeAt(index)
            true
        } ?: false
    }

    private fun loadMemos() {
        try {
            file.readLines().forEach { line ->
                val (title, content, timestamp) = line.split("||")
                val dateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                memos.add(Memo(title, content, dateTime))
            }
        } catch (e: FileNotFoundException) {
            // 파일이 존재하지 않으면 무시합니다.
        }
    }

    private fun saveMemos() {
        try {
            file.writeText(memos.joinToString("\n") { "${it.title}||${it.content}||${it.timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}" })
        } catch (e: IOException) {
            println("메모를 저장하는 중에 오류가 발생했습니다.")
        }
    }
}