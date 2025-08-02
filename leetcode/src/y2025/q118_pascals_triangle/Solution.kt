package y2025.q118_pascals_triangle

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = mutableListOf(listOf(1))
        for (i in 1..numRows - 1) {
            val row = mutableListOf<Int>()
            val prevRow = triangle[i - 1]
            row.add(1)
            if (i > 1) {
                for (j in 1..i - 1) {
                    row.add(prevRow[j - 1] + (prevRow.getOrNull(j) ?: 0))
                }
            }
            row.add(1)
            triangle.add(row)
        }
        return triangle
    }
}

fun main() {
    val res = Solution().generate(
        3
    )
    println(res)
}