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
}