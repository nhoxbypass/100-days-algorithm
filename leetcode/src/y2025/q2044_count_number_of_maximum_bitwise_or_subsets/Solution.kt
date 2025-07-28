package y2025.q2044_count_number_of_maximum_bitwise_or_subsets

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun countMaxOrSubsets(nums: IntArray): Int {
        // the maximum bitwise-OR is the bitwise-OR of the whole array
        val maxBitwise = nums.reduce { accumulates, num ->
            accumulates or num
        }

        dfs(nums, 0, 0, maxBitwise)

        return count
    }

    var count = 0

    private fun dfs(nums: IntArray, index: Int, currBitwise: Int, maxBitwise: Int) {
        if (index == nums.size) {
            if (currBitwise == maxBitwise) {
                count++
            }
            return
        }

        // exclude `nums[index]`
        dfs(nums, index + 1, currBitwise, maxBitwise)

        // include `nums[index]`
        dfs(nums, index + 1, currBitwise or nums[index], maxBitwise)
    }
}

fun main() {
    val res = Solution().countMaxOrSubsets(
        intArrayOf(3, 1)
    )
    println(res)
}