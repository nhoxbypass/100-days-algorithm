package y2025.q2529_maximum_count_of_positive_integer_and_negative_integer

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun maximumCount(nums: IntArray): Int {
        val N = nums.size

        var zeroCount = 0
        for (i in 0..<N) {
            if (nums[i] > 0) {
                // because `nums` sorted in non-decreasing order
                // -> we use the index of first positive number as a pivot to count (no need to loop through entire `nums`)
                val pos = N - i
                val neg = N - pos - zeroCount
                return Math.max(pos, neg)
            } else if (nums[i] == 0) {
                zeroCount++
            }
        }

        return N - zeroCount
    }
}

fun main() {
    val res = Solution().maximumCount(
        intArrayOf(-2, -1, -1, 1, 2, 3)
    )
    println(res)
}