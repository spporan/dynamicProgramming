package tabulation

fun main() {
    println("gridTravel of 1 * 1 : ${gridTravel(1, 1)}")
    println("gridTravel of 1 * 3 : ${gridTravel(1, 3)}")
    println("gridTravel of 2 * 2 : ${gridTravel(2, 2)}")
    println("gridTravel of 2 * 2 : ${gridTravel(2, 2)}")
    println("gridTravel of 3 * 3 : ${gridTravel(3, 3)}")
    println("gridTravel of 3 *  2 : ${gridTravel(3 ,2)}")
    println("gridTravel of 4 * 4 : ${gridTravel(4, 4)}")
    println("gridTravel of 18 * 18 : ${gridTravel(18, 18)}")

}

/**
 * Grid travel problem solved using tabulation
 *  complexity
 *  time: O(m * n)
 *  space: O(m * n)
 */
private fun gridTravel(m: Int, n: Int): Long {
    val  table: Array<Array<Long>> = Array(m + 1) {
        Array(n +1) {
            0
        }
    }
    table[1][1] = 1

    for (i in 0 .. m ) {
        for (j in  0 .. n) {
            val  current  =  table[i][j]

            if (j + 1 <= n) {
                table[i][j+1] += current
            }
            if (i + 1 <= m) {
                table[i+1][j] += current
            }
        }
    }
    println("arr ${table.toList().map { it.toList() }}")
    return table[m][n]

}