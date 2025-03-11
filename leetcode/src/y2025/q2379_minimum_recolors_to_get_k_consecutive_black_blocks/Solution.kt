package y2025.q2379_minimum_recolors_to_get_k_consecutive_black_blocks

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun minimumRecolors(blocks: String, k: Int): Int {
        val N = blocks.length

        var count = 0
        for (i in 0 until k) {
            if (blocks[i] == 'W') count++
        }

        var minCount = count
        for (i in 1..N - k) {
            if (count == 0)
                return 0
            if (blocks[i - 1] == 'W') {
                count--
            }
            if (blocks[i + k - 1] == 'W') {
                count++
            }
            if (minCount > count) {
                minCount = count
            }
        }

        return minCount
    }
}

fun main() {
    val res = Solution().minimumRecolors(
        "WBBWWBBWBW",
        7
    )
    println(res)
}