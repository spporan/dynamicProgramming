fun main() {
    println("can best sum 7 : ${bestSumUsingMemorizing(7, arrayOf(2, 3, 4, 7))?.toList()}")
    println("can best  sum 8 : ${bestSumUsingMemorizing(8, arrayOf(2, 3, 5))?.toList()}")
    println("can best  sum 8 : ${bestSumUsingMemorizing(8, arrayOf(1, 4, 5))?.toList()}")

    println("can sum 7 : ${bestSumUsingMemorizing(7, arrayOf(2, 5))?.toList()}")
    println("can sum 100 : ${bestSumUsingMemorizing(100, arrayOf(1,  2, 5, 25))?.toList()}")
}

/**
 * Solved using memorizing approach
 *
 * n = size of the numbers
 * m = target sum
 *
 * complexity
 * time = O (m * m * n) = O(m^2 * n) ## n  number of the branches or node and m is  the target sum or height of max recursion and another m for copying array
 * space = O(m * m) = max depth of  node * every recursion we have stored array in a  variable = O(m^2)
 * O(m^2)
 *
 */
fun bestSumUsingBruteForce(target: Int, numbers: Array<Int>): Array<Int>? {
    if (target ==  0) return arrayOf()

    if (target < 0) return null
    var shortestCombination: Array<Int>? = null

    numbers.map { num->
        val  reminder = target - num
        val reminderResult = bestSumUsingBruteForce(reminder, numbers)

        if (reminderResult != null) {
            val combination = reminderResult.plus(num)
            if (shortestCombination == null || (shortestCombination?.size ?: 0) > combination.size) {
                shortestCombination = combination
            }
        }
    }
    return shortestCombination
}


/**
 * Solved using brute force
 *
 * n = size of the numbers
 * m = target sum
 *
 * complexity
 * time = O (n^m * m) ## n  number of the branches or node and m is  the target sum or height of max recursion
 * space = O(m * m) = max depth of  node * every recursion we have stored array in a  variable = O(m^2)
 * O(m^2)
 *
 */
fun bestSumUsingMemorizing(target: Long, numbers: Array<Long>, memo: HashMap<Long, Array<Long>?> = hashMapOf() ): Array<Long>? {
    if (memo.containsKey(target)) return memo.getValue(target)

    if (target ==  0L) return arrayOf()

    if (target < 0) return null
    var shortestCombination: Array<Long>? = null

    numbers.map { num->
        val  reminder = target - num
        val reminderResult = bestSumUsingMemorizing(reminder, numbers, memo)

        if (reminderResult != null) {
            val combination = reminderResult.plus(num)
            if (shortestCombination == null || (shortestCombination?.size ?: 0) > combination.size) {
                shortestCombination = combination
                //memo[reminder] = combination
            }
        }
    }
    memo[target] =  shortestCombination
    return shortestCombination
}