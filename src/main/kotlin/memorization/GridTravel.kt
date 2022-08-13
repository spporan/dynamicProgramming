fun main(args: Array<String>) {
    println("Hello World!")


    println("grid travel of 2 * 2 ${gridTravelByDP(2, 3)}")
    println("grid travel of 3 * 3 ${gridTravelByDP(3,3)}")
    println("grid travel of 18 * 18 ${gridTravelByDP(18,18)}")
}



//grid travel
/**
 * solve using brute force
 *
 *  time complexity O (2^(n+m)) ###  where m and  n are the two input and  every root node have 2 two child
 *  array.
 *
 *  space complexity O(m+n)  ### where m and  n are the two input
 */
fun gridTravel(m: Int, n: Int): Int {
    if (n == 0 || m == 0) return 0 // base case

    if (n == 1 && m == 1) return 1 //base case
    //down m-1, n
    // right m, n-1
    return gridTravel(m-1, n) + gridTravel(m, n-1)
}

/**
 * solve following the memorizing method
 *
 *  time complexity O (n*m) ###  where m is the height of the tree and n the number of times being executed
 *  array.
 *
 *  space complexity O(m+n)  ### where m and  n are the two input
 */
fun gridTravelByDP(m: Int, n: Int, memo: HashMap<String, Long> = hashMapOf<String, Long>()): Long {
    val key = "$m,$n"
    // if check  already  have calculated this path. if calculated then just return from the map
    if (memo.containsKey(key)) return memo.getValue(key)

    if (n == 0 || m == 0) return 0 // base case

    if (n == 1 && m == 1) return 1 //base case

    val value = gridTravelByDP(m-1, n, memo) + gridTravelByDP(m, n-1, memo)
    memo[key] = value
    return memo.getValue(key)
}