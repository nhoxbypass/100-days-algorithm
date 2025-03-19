package y2025.q3191_minimum_operations_to_make_binary_array_elements_equal_to_one_i

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun minOperations(nums: IntArray): Int {
        val N = nums.size

        var operationCount = 0
        for (i in 0 until N - 2) {
            if (nums[i] == 0) {
                flip(nums, i)
                flip(nums, i + 1)
                flip(nums, i + 2)
                operationCount++
            }
        }

        return if (nums[N - 2] != 1 || nums[N - 1] != 1) {
            -1
        } else {
            operationCount
        }
    }

    private fun flip(nums: IntArray, idx: Int) {
        nums[idx] = nums[idx] xor 1
    }
}

fun main() {
    val res = Solution().minOperations(
        intArrayOf(0, 1, 1, 1, 0, 0)
    )
    println(res)
}