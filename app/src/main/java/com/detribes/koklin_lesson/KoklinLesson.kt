package com.detribes.koklin_lesson

fun main() {
    println(firstTask("(ыыы)"))
    println(secondTask(listOf(0, 1, 2, 3)) { list -> list.map { it * 2 } })
    println("Jopa".thirdTask())
    println(listOf(5, 2, 8, 6, 1, 9).fourthTask())
    println(fifthTask("jopa", null))
}

fun firstTask(str: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (ch in str) {
        when (ch) {
            '(', '[', '{' -> stack.addLast(ch)
            ')' -> {
                if (stack.isEmpty() || stack.removeLast() != '(') return false
            }

            ']' -> {
                if (stack.isEmpty() || stack.removeLast() != '[') return false
            }

            '}' -> {
                if (stack.isEmpty() || stack.removeLast() != '{') return false
            }
        }
    }

    return stack.isEmpty()
}

inline fun <T> secondTask(list: List<T>, operation: (List<T>) -> List<T>): List<T> {
    return operation(list)
}

fun String.thirdTask(): Int {
    val vowels = "aeiouAEIOU"
    var count = 0
    for (char in this) {
        if (char in vowels) {
            count++
        }
    }
    return count
}

fun List<Int>.fourthTask(): Double {
    val sortedList = this.sorted()
    val size = sortedList.size
    return if (size % 2 == 0) {
        val mid1 = sortedList[size / 2 - 1]
        val mid2 = sortedList[size / 2]
        (mid1 + mid2) / 2.0
    } else sortedList[size / 2].toDouble()
}

fun fifthTask(s1: String?, s2: String?): String {
    val first = s1 ?: ""
    val second = s2 ?: ""
    return first + second
}

