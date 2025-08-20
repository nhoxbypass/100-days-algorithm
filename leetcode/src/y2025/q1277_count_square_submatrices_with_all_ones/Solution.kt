package y2025.q1277_count_square_submatrices_with_all_ones

class Solution {
    /**
     * - Time complexity: O(M x N)
     * - Space complexity: O(M x N)
     */
    fun countSquares(matrix: Array<IntArray>): Int {
        val M = matrix.size
        val N = matrix[0].size

        // use a `dp[][]` array
        // each item `dp[i][j]` represents the size of the largest square ENDING at position (i,j)
        val dp = Array(M) { IntArray(N) }

        // square count (we sum dp while calculating `dp[][]`)
        var count = 0

        for (i in 0..<M) {
            for (j in 0..<N) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1
                    } else {
                        // minDP = min of 3 adjacent blocks
                        // minDP = min(dp[i-1][j],    // top
                        //             dp[i][j-1],    // left
                        //             dp[i-1][j-1]   // diagonal
                        //         )
                        val minDP = dp[i - 1][j]
                            .coerceAtMost(dp[i][j - 1])
                            .coerceAtMost(dp[i - 1][j - 1])
                        dp[i][j] = minDP + 1
                    }
                    // instead of sum `dp[][]` in the end (which cost O(MxN))
                    // we sum dp while calculating `dp[][]`
                    count += dp[i][j]
                }
            }
        }

        //return dp.sumOf { it.sum() }
        return count
    }
}

fun main() {
    val res = Solution().countSquares(
        arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )
    )
    println(res)
}