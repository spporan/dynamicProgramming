fun main() {
    println("can sum 7 : ${canSum(7, arrayOf(2, 3, 4, 7))}")
    println("can sum 7 : ${canSum(7, arrayOf(2, 3))}")
    println("can sum 7 : ${canSum(7, arrayOf(2, 5))}")
    println("can sum 8 : ${canSum(8, arrayOf(2, 3, 5))}")
    println("can sum 300 : ${canSum(300, arrayOf(7, 14))}")
}

fun canSum(target: Int, numbers: Array<Int>): Boolean {
    if (target == 0) return true

    if (target < 0) return false

    numbers.map { num->
        val reminder = target - num
        if (canSum(reminder, numbers)) return true
    }

    return false
}