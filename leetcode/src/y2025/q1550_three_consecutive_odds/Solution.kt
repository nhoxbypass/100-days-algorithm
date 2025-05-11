package y2025.q1550_three_consecutive_odds

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        val N = arr.size
        for (i in 0..N - 3) {
            if (arr[i] % 2 == 1 &&
                arr[i + 1] % 2 == 1 &&
                arr[i + 2] % 2 == 1) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val res = Solution().threeConsecutiveOdds(
        intArrayOf(2, 6, 4, 1)
    )
    println(res)
}