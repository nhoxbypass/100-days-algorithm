package y2025.q1534_count_good_triplets

import kotlin.math.abs

class Solution {
    /**
     * - Time complexity: O(N^3)
     * - Space complexity: O(1)
     */
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        val N = arr.size

        var count = 0
        for (i in 0..<N) {
            for (j in i + 1..<N) {
                for (k in j + 1..<N) {
                    if (abs(arr[i] - arr[j]) <= a &&
                        abs(arr[j] - arr[k]) <= b &&
                        abs(arr[i] - arr[k]) <= c
                    ) {
                        count++
                    }
                }
            }
        }

        return count
    }
}

fun main() {
    val res = Solution().countGoodTriplets(
        intArrayOf(3, 0, 1, 1, 9, 7),
        7, 2, 3
    )
    println(res)
}