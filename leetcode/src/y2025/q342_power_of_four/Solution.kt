package y2025.q342_power_of_four

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) return false
        val MAX_N = Int.MAX_VALUE.toLong() // input range: 2^31 - 1
        var pow = 1.0
        while (true) {
            if (pow.toLong() == n.toLong()) return true
            if (pow > n || pow > MAX_N) return false
            pow *= 4
        }
    }
}

fun main() {
    val res = Solution().isPowerOfFour(
        4
    )
    println(res)
}