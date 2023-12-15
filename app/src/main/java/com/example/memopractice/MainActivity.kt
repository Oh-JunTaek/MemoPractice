package com.example.memopractice

fun main() {
    val memoManager = MemoManager()
    println("안녕하세요 메모장입니다.")

    while (true) {
        println("새로운 메모를 작성하시려면 1, 저장된 메모를 보려면 2, 메모장을 종료하려면 0을 입력하세요.")
        when (readLine() ?: "") {
            "1" -> {
                println("메모의 제목을 입력해 주세요. 취소하려면 /main을 입력해 주세요")
                val title = readLine() ?: ""
                if (title == "/main") {
                    println("메모 작성을 취소합니다.")
                    continue
                }
                println("메모 내용을 입력해 주세요. 메모 작성을 취소하려면 /main 을 입력해주세요.")
                val content = readLine() ?: ""
                if (content == "/main") {
                    println("메모 작성을 취소합니다.")
                } else {
                    memoManager.add(Memo(title, content))
                    println("메모가 저장되었습니다.")
                }
            }
            "2" -> {
                val memos = memoManager.list()
                if (memos.isEmpty()) {
                    println("저장된 메모가 없습니다.")
                } else {
                    memos.forEachIndexed { index, memo ->
                        println("${index + 1}. ${memo.title}")
                    }
                    println("보고 싶은 메모의 번호를 입력하세요. 처음 화면으로 돌아가려면 0을 입력하세요.")
                    val index = readLine()?.toIntOrNull() ?: -1
                    if (index == 0) {
                        continue
                    }
                    val selectedMemo = memoManager.get(index - 1)
                    if (selectedMemo != null) {
                        println("제목: ${selectedMemo.title}")
                        println("내용: ${selectedMemo.content}")
                        println("메모를 수정하려면 1, 메모를 삭제하려면 2, 처음 화면으로 돌아가려면 0을 입력하세요.")
                        when (readLine() ?: "") {
                            "1" -> {
                                println("새 제목을 입력해 주세요. 취소하려면 /main을 입력해 주세요")
                                val newTitle = readLine() ?: ""
                                if (newTitle == "/main") {
                                    println("메모 수정을 취소합니다.")
                                    continue
                                }
                                println("새 내용을 입력해 주세요. 취소하려면 /main을 입력해 주세요")
                                val newContent = readLine() ?: ""
                                if (newContent == "/main") {
                                    println("메모 수정을 취소합니다.")
                                } else {
                                    memoManager.update(index - 1, Memo(newTitle, newContent))
                                    println("메모가 수정되었습니다.")
                                }
                            }
                            "2" -> {
                                memoManager.remove(index - 1)
                                println("메모가 삭제되었습니다.")
                            }
                            "0" -> continue
                            else -> println("[ERROR] 입력한 값을 다시 확인해 주세요.")
                        }
                    } else {
                        println("[ERROR] 입력한 값을 다시 확인해 주세요.")
                    }
                }
            }
            "0" -> {
                println("메모장을 종료합니다.")
                return
            }
            else -> {
                println("[ERROR] 입력한 값을 다시 확인해 주세요.")
            }
        }
    }
}