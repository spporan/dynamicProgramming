fun main() {
    println("can sum 7 : ${howSumFromArray(7, arrayOf(2, 3, 4, 7))?.toList()}")
    println("can sum 7 : ${howSumFromArray(7, arrayOf(2, 4))?.toList()}")
    println("can sum 7 : ${howSumFromArray(7, arrayOf(2, 5))?.toList()}")

    println("can sum 7 : ${howSumFromArray(7, arrayOf(2, 5))?.toList()}")
    println("can sum 300 : ${howSumFromArray(300, arrayOf(7, 14))}")

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