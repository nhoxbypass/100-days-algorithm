package y2025.q2348_number_of_zero_filled_subarrays

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun zeroFilledSubarray(nums: IntArray): Long {
        // For each zero, you can calculate:
        // the number of "zero-filled sub-array" that end on that index
        // which is the number of consecutive zeros behind the current element + 1
        // ---> Keep the idea of above, but don't need a temp array

        var subArrCount = 0L
        var consecutiveZeroCount = 0
        for (i in 0..<nums.size) {
            if (nums[i] == 0) {
                consecutiveZeroCount++
                subArrCount += consecutiveZeroCount
            } else {
                // reset consecutive zeros count
                consecutiveZeroCount = 0
            }
        }
        return subArrCount
    }

    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun zeroFilledSubarrayOld(nums: IntArray): Long {
        // For each zero, you can calculate:
        // the number of "zero-filled sub-array" that end on that index
        // which is the number of consecutive zeros behind the current element + 1

        val N = nums.size
        // subArrCount[idx] = number of sub-array that end on index `idx`
        var subArrCount = LongArray(N) { 0 }
        for (i in 0..<N) {
            if (nums[i] == 0) {
                // subArrCount[idx] = subArrCount[idx - 1] + 1
                val prevCount = subArrCount.getOrNull(i - 1) ?: 0
                subArrCount[i] = prevCount + 1
            }
        }

        // return sum of the sub-array count
        return subArrCount.sum()
    }
}

fun main() {
    val res = Solution().zeroFilledSubarray(
        intArrayOf(1, 3, 0, 0, 2, 0, 0, 4)
    )
    println(res)
}