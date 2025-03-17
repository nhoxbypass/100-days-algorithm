package y2025.q2206_divide_array_into_equal_pairs

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun divideArray(nums: IntArray): Boolean {
        val countMap = mutableMapOf<Int, Int>()
        nums.forEach {
            countMap[it] = countMap.getOrDefault(it, 0) + 1
        }
        countMap.values.forEach { count ->
            if (count % 2 == 1) return false
        }
        return true
    }
}

fun main() {
    val res = Solution().divideArray(
        intArrayOf(3, 2, 3, 2, 2, 2)
    )
    println(res)
}