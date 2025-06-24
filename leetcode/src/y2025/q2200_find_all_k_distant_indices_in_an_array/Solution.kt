package y2025.q2200_find_all_k_distant_indices_in_an_array

import kotlin.math.abs

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        // find the indices of `key`
        val keyIndices = mutableListOf<Int>()
        for (j in nums.indices) {
            if (nums[j] == key) {
                keyIndices.add(j)
            }
        }

        if (keyIndices.isEmpty()) return emptyList()

        val indices = mutableListOf<Int>()
        for (i in nums.indices) {
            val j = keyIndices.firstOrNull() ?: break
            if (abs(i - j) <= k) {
                // valid distance: |i - j| <= k
                indices.add(i)
            }
            if (i - j >= k) {
                // `i` has passed `j + k` distance
                // remove `j`
                keyIndices.removeFirst()
            }
        }
        return indices
    }
}

fun main() {
    val res = Solution().findKDistantIndices(
        intArrayOf(3, 4, 9, 1, 3, 9, 5),
        9,
        1
    )
    println(res)
}