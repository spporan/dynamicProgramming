fun main() {
    println("countConstruct : purple")
    println(" ${countConstructFromSubStringUsingMemo("purple", arrayOf("purp", "p", "ur", "le", "purpl"))}")
    println("countConstruct : abcdef")
    println(" ${countConstructFromSubStringUsingMemo("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))}")
    println("countConstruct : skateboard")
    println("${countConstructFromSubStringUsingMemo("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar"))}")
    println("countConstruct : enterapotentpot")
    println(" ${countConstructFromSubStringUsingMemo("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))}")
    println("countConstruct: eeeeeeeeeeeeeef")
    println("${countConstructFromSubStringUsingMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e", "ee", "eee", "eeee", "eeeee","eeeee", "eeeeeeee"))}")
}

/**
 * countConstructFromSubString solved using brute force
 *
 * Complexity of this programme
 * n = size of sub string  array
 * m = length of targetString
 * time: O(n^m * m)
 * space: O(m * m) = length of targetedString * worst case of removePrefix function = O(m^2)
 */
fun countConstructFromSubString(targetString: String, wordBank: Array<String>): Int {
    if (targetString.isEmpty() || targetString.isBlank()) return 1

    var totalCount = 0

    wordBank.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            val countMatch = countConstructFromSubString(remindString, wordBank)
            totalCount += countMatch
        }
    }
    return totalCount
}

/**
 * countConstructFromSubString solved using memorizing technique
 *
 * Complexity of this programme
 * n = size of sub string  array
 * m = length of targetString
 * time: O(n * m * m) = O(n * m^2)
 * space: O(m * m) = length of targetedString * worst case of removePrefix function = O(m^2)
 */
fun countConstructFromSubStringUsingMemo(targetString: String, wordBank: Array<String>, memo: HashMap<String, Long> = hashMapOf()): Long {

    if (memo.containsKey(targetString)) return memo.getValue(targetString)

    if (targetString.isEmpty() || targetString.isBlank()) return 1

    var totalCount = 0L

    wordBank.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            val countMatch = countConstructFromSubStringUsingMemo(remindString, wordBank, memo)
            totalCount += countMatch
        }
    }
    memo[targetString] = totalCount
    return memo.getValue(targetString)
}
