package com.example.memopractice

class MemoManager {
    private val memos = mutableListOf<String>()

    fun add(memo: String) {
        memos.add(memo)
    }

    fun list(): List<String> {
        return memos
    }

    fun get(index: Int): String? {
        return if (index in memos.indices) {
            memos[index]
        } else {
            null
        }
    }
}