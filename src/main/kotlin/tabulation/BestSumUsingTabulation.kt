package tabulation

fun main() {
    println("bestSum 7 ${bestSum(7, arrayOf(2, 3))?.toList()}")
    println("bestSum 7 ${bestSum(7, arrayOf(2, 4))?.toList()}")

    println("bestSum 7 ${bestSum(7, arrayOf(5, 3, 4, 7))?.toList()}")

    println("bestSum 8 ${bestSum(8, arrayOf(1, 4, 5))?.toList()}")

    println("bestSum 300 ${bestSum(300, arrayOf(7, 14))?.toList()}")
}

/**
 * bestSum solved using Tabulation approach
 *
 * complexity
 * here
 *  m = targetedSum
 *  n = size of the numbers array
 *
 *  time = O (m * n * m) = O(m^2*n)
 *  space: O(m*m) = O(m^2)
 *
 */
private fun bestSum(targetedSum: Int, numbers: Array<Int>): Array<Int>? {
    val table: Array<Array<Int>?> = Array(targetedSum + 1){ _-> null }
    table[0] = emptyArray()

    table.forEachIndexed { index, sub ->
        if (sub != null) {
           for (num in numbers) {
               if (index + num <= targetedSum) {
                   val combination = sub.plus(num)
                   if (table[index + num].isNullOrEmpty() || combination.size < (table[index + num]?.size ?: 0)) {
                       table[index + num] = combination
                   }
               }
           }
        }
    }
    return table[targetedSum]
}