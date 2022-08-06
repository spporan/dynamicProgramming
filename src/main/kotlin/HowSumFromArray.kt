fun main() {
    println("can sum 7 : ${howSumFromArrayWithMemorization(7, arrayOf(2, 3, 4, 7))?.toList()}")
    println("can sum 7 : ${howSumFromArrayWithMemorization(7, arrayOf(2, 4))?.toList()}")
    println("can sum 7 : ${howSumFromArrayWithMemorization(7, arrayOf(2, 5))?.toList()}")

    println("can sum 7 : ${howSumFromArrayWithMemorization(7, arrayOf(2, 5))?.toList()}")
    println("can sum 300 : ${howSumFromArrayWithMemorization(300, arrayOf(7, 14))}")

}

/**
 * Solved by brute force
 *
 *
 * m = the  target sum
 * n = size of the numbers
 *
 * time complexity: O (n^m * m)
 * space complexity: O (m)
 */
fun howSumFromArray(target: Int, numbers: Array<Int>): Array<Int>? {
    if (target == 0) return arrayOf()

    if (target < 0) return null

    numbers.map { num ->
        val reminder = target - num
        val reminderResult = howSumFromArray(reminder, numbers)
        if (reminderResult != null) {
            return reminderResult.plus(num)
        }
    }
    return null
}

/**
 * Solved by memorization technique
 *
 *
 * m = the  target sum
 * n = size of the numbers
 *
 * time complexity: O (n* m * m) = O(n*m^2)
 * space complexity: O (m * m) = maximum number of key of map * the  value  of  map  maximum size of array = O(m^2)
 *  O(m^2)
 */
fun howSumFromArrayWithMemorization(target: Long, numbers: Array<Long>, memo: HashMap<Long, Array<Long>?> = hashMapOf()): Array<Long>? {

    if (memo.containsKey(target)) return memo.getValue(target)

    if (target == 0L) return arrayOf()

    if (target < 0) return null

    numbers.map { num ->
        val reminder = target - num
        val reminderResult = howSumFromArrayWithMemorization(reminder, numbers, memo)
        if (reminderResult != null) {
            memo[target] = reminderResult.plus(num)
            return memo[target]
        }
    }
    memo[target] = null
    return null
}