package y2025.q2176_count_equal_and_divisible_pairs_in_an_array

class Solution {
    /**
     * - Time complexity: O(N^3)
     * - Space complexity: O(1)
     */
    fun countPairs(nums: IntArray, k: Int): Int {
        val n = nums.size
        var count = 0
        for (i in 0..n - 2) {
            for (j in i + 1..n - 1) {
                // nums[i] == nums[j] AND (i * j) is divisible by k
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++
                }
            }
        }
        return count
    }
}

fun main() {
    val res = Solution().countPairs(
        intArrayOf(3, 1, 2, 2, 2, 1, 3),
        2
    )
    println(res)
}