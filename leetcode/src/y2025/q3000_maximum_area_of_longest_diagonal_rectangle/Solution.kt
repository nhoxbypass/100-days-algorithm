package y2025.q3000_maximum_area_of_longest_diagonal_rectangle

import kotlin.math.pow

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxDiagonal = 0.0
        var maxArea = 0
        for (i in 0..<dimensions.size) {
            val diagonal = dimensions[i][0].toDouble().pow(2.0) + dimensions[i][1].toDouble().pow(2.0)
            if (diagonal >= maxDiagonal) {
                val area = dimensions[i][0] * dimensions[i][1]
                maxArea = if (diagonal > maxDiagonal) {
                    area
                } else {
                    // equal diagonal -> compare max area
                    area.coerceAtLeast(maxArea)
                }
                maxDiagonal = diagonal
            }
        }
        return maxArea
    }
}

fun main() {
    val res = Solution().areaOfMaxDiagonal(
        arrayOf(
            intArrayOf(6, 5),
            intArrayOf(8, 6),
            intArrayOf(2, 10),
            intArrayOf(8, 1),
            intArrayOf(9, 2),
            intArrayOf(3, 5),
            intArrayOf(3, 5)
        )
    )
    println(res)
}