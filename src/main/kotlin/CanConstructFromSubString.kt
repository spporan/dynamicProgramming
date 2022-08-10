fun main() {
    println("canConstruct : abcdef")
    println(" ${canConstructUsingMemo("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"))}")
    println("canConstruct : skateboard")
    println("${canConstructUsingMemo("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar"))}")
    println("canConstruct : enterapotentpot")
    println(" ${canConstructUsingMemo("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))}")
    println("eeeeeeeeeeeeeef")
    println("${canConstructUsingMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e", "ee", "eee", "eeee", "eeeee","eeeee", "eeeeeeee"))}")
}

/**
 * CanConstructStringFromListOfSubString solved by memorizing technique
 *
 * complexity of the programme
 *
 * m = length of target string
 * n = size of subString array
 *
 * time : O(n * m)
 * space : O(m * m) = O(m^2) = length of target string * worst case of remove prefix
 *
 */

fun canConstructUsingMemo(
    targetString: String,
    subStrings: Array<String>,
    memo: HashMap<String, Boolean> = hashMapOf()
): Boolean {

    if (memo.containsKey(targetString)) return memo.getValue(targetString)

    if (targetString.isEmpty() || targetString.isBlank()) return true

    subStrings.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            if (canConstructUsingMemo(remindString, subStrings, memo)) {
                memo[remindString] = true
                return memo.getValue(remindString)
            }
        }
    }

    memo[targetString] = false
    return memo.getValue(targetString)
}

/**
 * CanConstructStringFromListOfSubString solved by brute force technique
 *
 * complexity of the programme
 *
 * m = length of target string
 * n = size of subString array
 *
 * time : O(n^m * m)
 * space : O(m * m) = O(m^2) = length of target string * worst case of remove prefix
 *
 */

fun canConstruct(targetString: String, subStrings: Array<String>): Boolean {
    if (targetString.isEmpty() || targetString.isBlank()) return true

    subStrings.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            if (canConstruct(remindString, subStrings)) return true
        }
    }
    return false
}