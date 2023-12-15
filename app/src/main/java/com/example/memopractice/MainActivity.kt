package com.example.memopractice

fun main() {
    val memoManager = MemoManager()


    println(Constants.HELLO)

    while (true) {
        println(Constants.INPUT_PROMPT)
        when (readLine() ?: "") {
            "1" -> {
                println(Constants.TITLE_PROMPT)
                val title = readLine() ?: ""
                if (title == "/main") {
                    println(Constants.CANCEL)
                    continue
                }
                println(Constants.CONTENT_PROMPT)
                val content = readLine() ?: ""
                if (content == "/main") {
                    println(Constants.CANCEL)
                    continue
                }
                memoManager.add(Memo(title, content))
                println(Constants.SAVED_MEMO)
            }
            "2" -> {
                val memos = memoManager.list()
                if (memos.isEmpty()) {
                    println(Constants.NO_SAVED_MEMO)
                    continue
                }
                memos.forEachIndexed { index, memo ->
                    println("${index + 1}. ${memo.title} - ${memo.formattedTime()}")
                }
                println(Constants.FIND_MEMO)
                val index = readLine()?.toIntOrNull() ?: -1
                if (index == 0) {
                    continue
                }
                val selectedMemo = memoManager.get(index - 1)
                if (selectedMemo != null) {
                    println("제목: ${selectedMemo.title}")
                    println("내용: ${selectedMemo.content}")
                    println(Constants.EDIT_PROMPT)
                    when (readLine() ?: "") {
                        "1" -> {
                            println(Constants.TITLE_PROMPT)
                            val newTitle = readLine() ?: ""
                            if (newTitle == "/main") {
                                println(Constants.CANCEL)
                                continue
                            }
                            println(Constants. CONTENT_PROMPT)
                            val newContent = readLine() ?: ""
                            if (newContent == "/main") {
                                println(Constants.CANCEL)
                                continue
                            }
                            memoManager.update(index - 1, Memo(newTitle, newContent))
                            println(Constants.EDIT_MEMO)
                        }
                        "2" -> {
                            memoManager.remove(index - 1)
                            println(Constants.DELETED_MEMO)
                        }
                        "0" -> continue
                        else -> println(Constants.ERROR_MESSAGE)
                    }
                } else {
                    println(Constants.ERROR_MESSAGE)
                }
            }
            "0" -> {
                println(Constants.END_MEMO)
                return
            }
            else -> {
                println(Constants.ERROR_MESSAGE)
            }
        }
    }
}
