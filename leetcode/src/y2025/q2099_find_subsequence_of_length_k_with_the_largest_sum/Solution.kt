package y2025.q2099_find_subsequence_of_length_k_with_the_largest_sum

import java.util.*

class Solution {
    /**
     * - Time complexity: O(Nk)
     * - Space complexity: O(k)
     */
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        // PQ that sort the `index` based on `nums[index]` values (ASC)
        val ascIndices = PriorityQueue<Int> { a, b ->
            nums[a] - nums[b]
        }

        // find the indices of the top `k` numbers in `nums`
        for (i in nums.indices) {
            ascIndices.add(i)
            if (ascIndices.size > k) {
                ascIndices.poll()
            }
        }

        // match the indices with the real values in `nums`
        val result = IntArray(k)
        var idx = 0
        for (i in nums.indices) {
            if (ascIndices.contains(i)) {
                result[idx++] = nums[i]
            }
        }

        return result
    }

    fun maxSubsequenceOld(nums: IntArray, k: Int): IntArray {
        val topNums = nums.sorted().takeLast(k).toMutableList()
        val result = IntArray(k)
        var idx = 0
        nums.forEach {
            if (topNums.contains(it)) {
                result[idx++] = it
                topNums.remove(it)
            }
        }
        return result
    }
}

fun main() {
    val res = Solution().maxSubsequence(
        intArrayOf(3, 4, 3, 3),
        2
    )
    println(res)
}