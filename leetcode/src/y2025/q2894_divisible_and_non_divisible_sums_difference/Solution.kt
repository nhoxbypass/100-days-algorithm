package y2025.q2894_divisible_and_non_divisible_sums_difference

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun differenceOfSums(n: Int, m: Int): Int {
        var diff = 0
        for (num in 1..n) {
            if (num % m == 0) {
                diff -= num
            } else {
                diff += num
            }
        }
        return diff
    }
}

fun main() {
    val res = Solution().differenceOfSums(
        10,
        3
    )
    println(res)
}