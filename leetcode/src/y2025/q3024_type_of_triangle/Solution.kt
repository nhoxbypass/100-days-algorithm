package y2025.q3024_type_of_triangle

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun triangleType(nums: IntArray): String {
        nums.sort()

        val smallest = nums[0]
        val mid = nums[1]
        val biggest = nums[2]

        return when {
            smallest + mid <= biggest -> "none"
            smallest == mid && mid == biggest -> "equilateral"
            smallest == mid || mid == biggest -> "isosceles"
            else -> "scalene"
        }
    }
}

fun main() {
    val res = Solution().triangleType(
        intArrayOf(3, 3, 3)
    )
    println(res)
}