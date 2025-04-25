package y2025.q2799_count_complete_subarrays_in_an_array

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun countCompleteSubarrays(nums: IntArray): Int {
        val totalDistinctCount = nums.toSet().size

        val freqMap = HashMap<Int, Int>()
        var l = 0
        var subArrCount = 0
        for (r in nums.indices) {
            freqMap[nums[r]] = freqMap.getOrDefault(nums[r], 0) + 1
            while (freqMap.size == totalDistinctCount) {
                subArrCount += nums.size - r
                freqMap[nums[l]] = freqMap[nums[l]]!! - 1
                if (freqMap[nums[l]] == 0) freqMap.remove(nums[l])
                l++
            }
        }

        return subArrCount
    }
}

fun main() {
    val res = Solution().countCompleteSubarrays(
        intArrayOf(1, 3, 1, 2, 2)
    )
    println(res)
}