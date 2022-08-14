package tabulation

fun main() {
    println("canConstruct : abcdef")
    println(" ${canConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))}")
    println("canConstruct : skateboard")
    println("${canConstruct("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar"))}")
    println("canConstruct : enterapotentpot")
    println(" ${canConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))}")
    println("eeeeeeeeeeeeeef")
    println("${canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e", "ee", "eee", "eeee", "eeeee","eeeee", "eeeeeeee"))}")
}

/**
 * CanConstruct solved using Tabulation approach
 *
 * Complexity
 *  here,
 *    m = length of targetString
 *    n = size of the word bank
 *
 *    time: O(m * n * m) = O(m^2*n)
 *    space: O(m)
 *
 */
private fun canConstruct(targetString: String, wordBank: Array<String>): Boolean {
    val table: Array<Boolean> = Array(targetString.length + 1) {_ -> false }

    table[0] = true // where base case is empty string

    table.forEachIndexed { index, check ->
        if (check) {
            for (word in wordBank) {
                if ((index + word.length <= targetString.length)
                    && targetString.slice(index until index + word.length).startsWith(word)
                ) {
                    table[index  + word.length]  = true
                }
            }
        }
    }

    return table[targetString.length]
}