package y2025.q2962_count_subarrays_where_max_element_appears_at_least_k_times

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun countSubarrays(nums: IntArray, k: Int): Long {
        // find the max number of `nums`
        val maxNum = nums.max()

        var freqCount = 0
        var subArrCount = 0L
        var startIdx = 0
        for (endIdx in nums.indices) {
            if (nums[endIdx] == maxNum) {
                freqCount++
            }
            while (freqCount >= k) {
                if (nums[startIdx] == maxNum) {
                    freqCount--
                }
                startIdx++
            }
            subArrCount += startIdx
        }
        return subArrCount
    }
}

fun main() {
    val res = Solution().countSubarrays(
        intArrayOf(1, 3, 2, 3, 3),
        2
    )
    println(res)
}