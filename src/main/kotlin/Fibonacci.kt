fun main() {
    println("fib of 5 ${fib(5)}")
    println("fib of 8 ${fib(8)}")
    println("fib of 50 ${fib(50)}")
}


/**
 * fibonacci number solved by brute force technique
 *
 * time complexity O (2^n) ###  where n is the level of tree, every root node have 2 two child
 *  array.
 *
 *  space complexity O(n)  ### where n is the level of the tree
 */
fun fibWithBruteForce(n: Long): Long {
    if (n <= 2) return 1
    return fib(n-1) + fib(n-2)
}

/**
 * fibonacci number solved by memorizing technique
 *
 *  time complexity O (n) ###  where n is the level of tree
 *  array.
 *
 *  space complexity O(n)  ### where n is the level of the tree
 */
fun fib(n: Long, map: HashMap<Long, Long> = hashMapOf<Long, Long>()): Long {
    if (map.containsKey(n)) return map.getValue(n)

    if (n <= 2) return 1

    val value = fib(n-1, map) + fib(n-2, map)
    map[n] = value
    return map.getValue(n)
}