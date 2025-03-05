package y2025.q2579_count_total_number_of_colored_cells

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun coloredCells(n: Int): Long {
        if (n == 1) return 1
        return (4L * (n - 1)) + coloredCells(n - 1)
    }
}

fun main() {
    val res = Solution().coloredCells(
        3
    )
    println(res)
}