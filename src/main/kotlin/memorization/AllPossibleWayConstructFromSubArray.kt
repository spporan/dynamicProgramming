fun main() {
    println("countConstruct : purple")
    println(" ${allPossibleWayConstructFromSubStringArray("purple", arrayOf("purp", "p", "ur", "le", "purpl"))}")

    println("countConstruct memo: purple")
    println(" ${allPossibleWayConstructFromSubStringArrayUsingMemo("purple", arrayOf("purp", "p", "ur", "le", "purpl"))}")

    /*println("countConstruct : abcdef")
    println(" ${allPossibleWayConstructFromSubStringArrayUsingMemo("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))}")
    println("countConstruct : skateboard")
    println("${allPossibleWayConstructFromSubStringArrayUsingMemo("skateboard", arrayOf("bo", "rd", "ate", "t","ska","sk", "boar"))}")
    println("countConstruct : enterapotentpot")
    println(" ${allPossibleWayConstructFromSubStringArrayUsingMemo("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t"))}")
    println("countConstruct: eeeeeeeeeeeeeef")
    println("${allPossibleWayConstructFromSubStringArrayUsingMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("e", "ee", "eeee", "eeeee","eeeee", "eeeeeeee"))}")*/
}

/**
 * allPossibleWayConstructFromSubStringArray solved by using brute force technique
 *
 * Complexity
 * n = size of the word bank
 * m = length of the target string
 * time: O (n^m * m * m)
 * space:
 */
fun allPossibleWayConstructFromSubStringArray(targetString: String, wordBank: Array<String>): List<MutableList<String>> {
    if (targetString.isEmpty() || targetString.isBlank()) return listOf(mutableListOf())
    val result: MutableList<MutableList<String>> = mutableListOf()
    wordBank.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            val tempResult = allPossibleWayConstructFromSubStringArray(remindString, wordBank)
            val finalArray = tempResult.map { subArray ->
                subArray.add(0,sub)
                subArray
            }
            result += finalArray
        }
    }
    println("array $result")

    return result
}

/**
 * allPossibleWayConstructFromSubStringArray solved by using memorizing technique
 *
 * Complexity
 * n = size of the word bank
 * m = length of the target string
 * time: O (n^m * m * m)
 * space:
 */
fun allPossibleWayConstructFromSubStringArrayUsingMemo(
    targetString: String,
    wordBank: Array<String>,
    memo: HashMap<String, List<MutableList<String>>> = hashMapOf()
): List<MutableList<String>> {
    if (memo.containsKey(targetString)) return memo.getValue(targetString)

    if (targetString.isEmpty() || targetString.isBlank()) return listOf(mutableListOf())

    val result: MutableList<MutableList<String>> = mutableListOf()

    wordBank.map { sub ->
        if (targetString.startsWith(sub)) {
            val remindString = targetString.removePrefix(sub)
            val tempResult = allPossibleWayConstructFromSubStringArrayUsingMemo(remindString, wordBank, memo)
            val finalArray = tempResult.map { subList ->
                subList.add(0,sub)
                subList
            }

            result += finalArray
        }
    }

    println("array memo: $result")

    memo[targetString]  =  result

    return result
}