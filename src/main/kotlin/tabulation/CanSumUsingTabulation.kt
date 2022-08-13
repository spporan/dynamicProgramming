package tabulation

fun main() {
    println("CanSum 7 ${canSum(7, arrayOf(2, 3))}")

    println("CanSum 7 ${canSum(7, arrayOf(2, 4))}")

    println("CanSum 7 ${canSum(7, arrayOf(5, 3, 4, 7))}")

    println("CanSum 8 ${canSum(8, arrayOf(2, 3, 5))}")

    println("CanSum 300 ${canSum(300, arrayOf(7, 14))}")

}


/**
 *  CanSum problem solved by Tabulation approach
 *
 *  complexity:
 *  here,
 *    m = targetedNumber
 *    n = size of the numbers array
 *  time: O(m*n) = O(mn)
 *  space: O(m)
 *
 */
private fun canSum(target: Int, numbers: Array<Int>): Boolean {
    val table = Array(target + 1) { _-> false}
    table[0] = true

    table.forEachIndexed { index, check ->
        if (check) {
            for (num in numbers) {
                if (index + num <= target) {
                    table[index + num] = true
                }
            }
        }
    }

    return table[target]
}