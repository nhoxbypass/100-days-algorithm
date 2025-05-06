package y2025.q1920_build_array_from_permutation

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun buildArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in 0..nums.size - 1) {
            ans[i] = nums[nums[i]]
        }
        return ans
    }
}

fun main() {
    val res = Solution().buildArray(
        intArrayOf(0, 2, 1, 5, 3, 4)
    )
    println(res)
}