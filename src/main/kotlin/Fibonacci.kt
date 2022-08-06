fun main() {
    println("fib of 5 ${fib(5)}")
    println("fib of 8 ${fib(8)}")
    println("fib of 50 ${fib(50)}")
}

//fibonacci number by dynamic programming
fun fib(n: Long, map: HashMap<Long, Long> = hashMapOf<Long, Long>()): Long {
    if (map.containsKey(n)) return map.getValue(n)

    if (n <= 2) return 1

    val value = fib(n-1, map) + fib(n-2, map)
    map[n] = value
    return map.getValue(n)
}