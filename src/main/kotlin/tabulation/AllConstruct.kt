package tabulation

fun main() {
    println("countConstruct : purple")
    println(" ${allConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl")).toList().map { it.toList() }}")
    println("countConstruct : abcdef")
    println(" ${allConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd", "ef", "c")).toList().map { it.toList() }}")
    println("countConstruct : skateboard")
    println("${allConstruct("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar")).toList().map { it.toList() }}")
    println("countConstruct : enterapotentpot")
    println(" ${allConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")).toList().map { it.toList() }}")
    println("countConstruct: eeeeeeeeeeeeeef")
    println("${allConstruct("eeeeeeeeeeeeeef", arrayOf("e", "ee", "eeee", "eeeee","eeeee", "eeeeeeee")).toList().map { it.toList() }}")
}

/**
 * allConstruct solved using Tabulation approach
 *
 * Complexity
 * time: O(n^m)
 * space: O(n^m)
 */
private fun allConstruct(targetString: String, wordBank:Array<String>): Array<Array<String>> {
    val table: Array<Array<Array<String>>> = Array(targetString.length + 1) { _ -> emptyArray() }
    table[0] = arrayOf(emptyArray())

    table.forEachIndexed { index, arrays ->
        if (index == 0 || arrays.isNotEmpty()) {
            for (word in wordBank) {
                if (index + word.length <= targetString.length
                    && targetString.slice(index until  index + word.length) == word
                ) {
                    val combination = arrays.map { sub ->
                        sub.plus(word)
                    }

                    table[index + word.length] += combination.toTypedArray()
                }
            }
        }

    }
    return table[targetString.length]
}