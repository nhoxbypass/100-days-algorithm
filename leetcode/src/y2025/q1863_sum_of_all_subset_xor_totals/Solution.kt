package y2025.q1863_sum_of_all_subset_xor_totals

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun subsetXORSum(nums: IntArray): Int {
        travel(nums, 0, 0)
        return currSubsetSum
    }

    private var currSubsetSum = 0

    private fun travel(nums: IntArray, idx: Int, currXor: Int) {
        if (idx == nums.size) {
            // reach the end of `nums`
            // add to subset sum
            currSubsetSum += currXor
            return
        }

        // include number at current idx
        val xorVal = currXor xor nums[idx]
        travel(nums, idx + 1, xorVal)

        // ignore number at current idx
        travel(nums, idx + 1, currXor)
    }
}

fun main() {
    val res = Solution().subsetXORSum(
        intArrayOf(5, 1, 6)
    )
    println(res)
}