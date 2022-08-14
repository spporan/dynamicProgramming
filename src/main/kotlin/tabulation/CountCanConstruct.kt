package tabulation

fun main() {
    println("countConstruct : purple")
    println(" ${countConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl"))}")
    println("canConstruct : abcdef")
    println(" ${countConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))}")
    println("canConstruct : skateboard")
    println("${countConstruct("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar"))}")
    println("canConstruct : enterapotentpot")
    println(" ${countConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))}")
    println("eeeeeeeeeeeeeef")
    println("${countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e", "ee", "eee", "eeee", "eeeee","eeeee", "eeeeeeee"))}")
}

/**
 * countConstruct solved using Tabulation
 *
 * Complexity
 *  here,
 *   m = length of targetString
 *   n = size of the wordBank
 *
 *   time: O(m*n*m) = O(m^2*n)
 *   space: O(m)
 */
private fun countConstruct(targetString: String,  wordBank: Array<String>): Int {
    val table: Array<Int> = Array(targetString.length + 1) {_ -> 0}

    table[0] = 1 // It is a base case

    table.forEachIndexed { index, count ->
        if (count > 0) {
            for (word in wordBank) {
                if (index + word.length <= targetString.length
                    && targetString.slice(index until index + word.length) == word
                ) {
                    table[index + word.length] += table [index]
                }
            }
        }
    }

    return table[targetString.length]
}