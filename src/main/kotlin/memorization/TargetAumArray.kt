fun main() {
    println("can sum 7 : ${canSumWithMemo(7, arrayOf(2, 3, 4, 7))}")
    println("can sum 7 : ${canSumWithMemo(7, arrayOf(2, 3))}")
    println("can sum 7 : ${canSumWithMemo(7, arrayOf(2, 5))}")
    println("can sum 8 : ${canSumWithMemo(8, arrayOf(2, 3, 5))}")
    println("can sum 300 : ${canSumWithMemo(300, arrayOf(7, 14))}")
}

/**
 *  solved using brute force technique
 *
 *  time complexity O (n^m) ###  where m is the level of tree and n is the size of the
 *  array.
 *
 *  space complexity O(m)  ### where m is the level of the tree
 */

fun canSum(target: Int, numbers: Array<Int>): Boolean {
    if (target == 0) return true

    if (target < 0) return false

    numbers.map { num->
        val reminder = target - num
        if (canSum(reminder, numbers)) return true
    }

    return false
}

/**
 *  solved with memorize technique
 *
 *  time complexity O (n*m) ###  where m is the level of tree and n is the size of the
 *  array.
 *
 *  space complexity O(m)  ### where m is the level of the tree
 */
fun canSumWithMemo(target: Long, numbers: Array<Long>, memo: HashMap<Long, Boolean> = hashMapOf<Long, Boolean>()): Boolean {
    if (memo.containsKey(target)) return memo.getValue(target)

    if (target == 0L) return true

    if (target < 0L) return false

    numbers.map { num->
        val reminder = target - num
        if (canSumWithMemo(reminder, numbers, memo)) {
            memo[reminder] = true
            return true
        }
    }

    memo[target] = false
    return false
}