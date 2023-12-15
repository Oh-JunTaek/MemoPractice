package com.example.memopractice

fun main() {
    val memos = mutableMapOf<String, String>()
    val memoManager = MemoManager()

    while (true) {
        println("안녕하세요 메모장입니다.")
        println("새로운 메모를 작성하시려면 1, 저장된 메모를 보려면 2, 메모장을 종료하려면 0을 입력하세요.")
        when (readLine()) {
            "1" -> {
                println("메모의 제목을 입력해 주세요.")
                val title = readLine() ?: ""
                println("메모 내용을 입력해 주세요. 메모 작성을 취소하려면 /main 을 입력해주세요.")
                val content = readLine() ?: ""
                if (content == "/main") {
                    println("메모 작성을 취소합니다.")
                } else {
                    memoManager.add("$title: $content")
                    println("메모가 저장되었습니다.")
                }
            }
            "2" -> {
                val memos = memoManager.list()
                if (memos.isEmpty()) {
                    println("저장된 메모가 없습니다.")
                } else {
                    memos.forEachIndexed { index, memo ->
                        println("${index + 1}. $memo")
                    }
                    println("보고 싶은 메모의 번호를 입력하세요.")
                    val index = readLine()?.toIntOrNull() ?: 0
                    println(memoManager.get(index - 1) ?: "잘못된 번호입니다.")
                }
            }
            "0" -> {
                println("메모장을 종료합니다.")
                return
            }
            else -> {
                println("잘못된 입력입니다.")
            }
        }
    }
}