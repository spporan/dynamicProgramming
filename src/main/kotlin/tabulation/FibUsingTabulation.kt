package tabulation

fun main() {
    println("fib of 50 : ${fib(50)}")
    println("fib of 10 : ${fib(10)}")
    println("fib of 6 : ${fib(6)}")
}

/**
 * fib problem solved using tabulation
 * means that declared a (n + 1) size  of array with 0 initialize
 * and after that statically replace 1 at  the position of 1 index
 * Iterate until n and add the value of current index  with the pos of index + 1 and index + 2's value
 *
 * complexity
 * time: O(n)
 * space: O(n)
 */
private fun fib(n: Int): Long {
    val  sizeOf = n + 1
    val array: Array<Long> = Array(sizeOf) { _: Int -> 0 }
    array[1] = 1
    for (i in 0 until n) {
        if (i < sizeOf - 1) {
            array[i  + 1] += array[i]
        }
        if (i < sizeOf - 2) {
            array[i + 2]  += array[i]
        }
    }
    println("fib series  : ${array.toList()}")

    return array[n]
}