package y2025.q498_diagonal_traverse

class Solution {
    /**
     * - Time complexity: O(M x N)
     * - Space complexity: O(M x N)
     */
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val M = mat.size
        val N = mat[0].size
        val resultArr = IntArray(M * N)
        var row = 0
        var col = 0
        var moveUp = true

        // Iterate through all elements
        for (idx in resultArr.indices) {
            // Add the current element to the result array
            resultArr[idx] = mat[row][col]
            // Move to the next element based on the current direction
            if (moveUp) {
                // Move up-right
                if (col + 1 < N && row - 1 >= 0) {
                    row--
                    col++
                } else {
                    // Change direction
                    moveUp = false
                    // Adjust position
                    if (col + 1 < N) {
                        col++
                    } else {
                        row++
                    }
                }
            } else {
                // Move down-left
                if (row + 1 < M && col - 1 >= 0) {
                    row++
                    col--
                } else {
                    // Change direction
                    moveUp = true
                    // Adjust position
                    if (row + 1 < M) {
                        row++
                    } else {
                        col++
                    }
                }
            }
        }

        return resultArr
    }
}

fun main() {
    val res = Solution().findDiagonalOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )
    println(res)
}