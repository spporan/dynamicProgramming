package tabulation

fun main() {
    println("howSum 7 ${howSum(7, arrayOf(2, 3))?.toList()}")
    println("howSum 7 ${howSum(7, arrayOf(2, 4))?.toList()}")

    println("howSum 7 ${howSum(7, arrayOf(5, 3, 4, 7))?.toList()}")

    println("howSum 8 ${howSum(8, arrayOf(2, 3, 5))?.toList()}")

    println("howSum 300 ${howSum(300, arrayOf(7, 14))?.toList()}")
}

/**
 * HowSum solved using Tabulation approach
 *
 * Complexity
 * m = targeted number
 * n = size of the numbers
 *
 * time: O(m * n * m) = m is iterate * n size of numbers * m is the worst case of copying array
 *  O (m^2 * n)
 *  space: O(m * m) = m^2 deu to 2d array
 *  O(m^2)
 */
private fun howSum(targetSum: Int, numbers: Array<Int>): Array<Int>? {
    val table: Array<Array<Int>?> = Array(targetSum + 1) {_ -> null}
    table[0] = emptyArray()

    table.forEachIndexed { index, sub ->
        if (sub != null) {
            for (num in numbers) {
                if (index + num <= targetSum) {
                    table[index + num] = sub.plus(num)
                }
            }
        }
    }
    return table[targetSum]
}