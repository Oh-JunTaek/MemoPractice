package com.example.memopractice

class MemoManager {
    private val memos = mutableListOf<Memo>()

    fun add(memo: Memo) {
        memos.add(memo)
    }

    fun list(): List<Memo> {
        return memos
    }

    fun get(index: Int): Memo? {
        return if (index in memos.indices) {
            memos[index]
        } else {
            null
        }
    }

    fun update(index: Int, memo: Memo): Boolean {
        return if (index in memos.indices) {
            memos[index] = memo
            true
        } else {
            false
        }
    }

    fun remove(index: Int): Boolean {
        return if (index in memos.indices) {
            memos.removeAt(index)
            true
        } else {
            false
        }
    }
}