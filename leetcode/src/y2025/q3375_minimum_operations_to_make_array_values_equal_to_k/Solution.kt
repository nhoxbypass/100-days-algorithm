package y2025.q3375_minimum_operations_to_make_array_values_equal_to_k

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun minOperations(nums: IntArray, k: Int): Int {
        val distinctAboveK = HashSet<Int>()
        for (i in nums) {
            if (i < k) {
                // no door
                return -1
            }
            if (i > k) {
                distinctAboveK.add(i)
            }
            // ignore `i` that equal to `k`
        }
        return distinctAboveK.size
    }
}

fun main() {
    val res = Solution().minOperations(
        intArrayOf(5, 2, 5, 4, 5), 2
    )
    println(res)
}