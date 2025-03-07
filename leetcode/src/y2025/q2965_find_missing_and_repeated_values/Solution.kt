package y2025.q2965_find_missing_and_repeated_values

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size

        val countMap = mutableMapOf<Int, Int>()
        for (row in grid) {
            for (num in row) {
                countMap[num] = countMap.getOrDefault(num, 0) + 1
            }
        }

        val ans = IntArray(2)
        for (num in countMap.keys) {
            if (countMap[num] == 2) {
                ans[0] = num
                break
            }
        }
        for (i in 1..(n * n)) {
            if (!countMap.contains(i)) {
                ans[1] = i
                break
            }
        }

        return ans
    }
}

fun main() {
    val res = Solution().findMissingAndRepeatedValues(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 2)
        )
    )
    println(res)
}