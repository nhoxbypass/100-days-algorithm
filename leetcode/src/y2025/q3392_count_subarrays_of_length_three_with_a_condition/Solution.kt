package y2025.q3392_count_subarrays_of_length_three_with_a_condition

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun countSubarrays(nums: IntArray): Int {
        var subArrCount = 0
        for (i in 0..nums.size - 3) {
            if ((nums[i] + nums[i + 2]).toDouble() == (nums[i + 1] / 2.0)) {
                subArrCount++
            }
        }
        return subArrCount
    }
}

fun main() {
    val res = Solution().countSubarrays(
        intArrayOf(-1, -4, -1, 4)
    )
    println(res)
}