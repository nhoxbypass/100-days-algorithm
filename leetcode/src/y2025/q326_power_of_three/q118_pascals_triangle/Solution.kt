package y2025.q326_power_of_three.q118_pascals_triangle

import kotlin.math.pow

class Solution {
    /**
     * - Time complexity: O(Log3(N))
     * - Space complexity: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false
        val MAX_N = Int.MAX_VALUE.toLong() // input range: 2^31 - 1
        var pow = 1.0
        while (true) {
            if (pow.toLong() == n.toLong()) return true
            if (pow > n || pow > MAX_N) return false
            pow *= 3
        }
    }

    fun isPowerOfThreeOld(n: Int): Boolean {
        if (n <= 0) return false
        val MAX_N = 2.0.pow(31.0) - 1
        var x = 0.0
        while (true) {
            val pow = 3.0.pow(x).toLong()
            if (pow == n.toLong()) return true
            if (x >= n || pow > MAX_N) return false
            x++
        }
    }
}

fun main() {
    val res = Solution().isPowerOfThree(
        2147483647
    )
    println(res)
}