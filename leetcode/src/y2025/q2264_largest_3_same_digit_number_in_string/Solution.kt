package y2025.q2264_largest_3_same_digit_number_in_string

import kotlin.math.max

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun largestGoodInteger(num: String): String {
        var maxDigit = -1
        for (i in 2..<num.length) {
            val c = num[i]
            if (num[i - 2] == c && num[i - 1] == c) {
                maxDigit = max(maxDigit, c.digitToInt())
            }
        }

        if (maxDigit == -1) return ""

        return "$maxDigit$maxDigit$maxDigit"
    }
}

fun main() {
    val res = Solution().largestGoodInteger(
        "6777133339"
    )
    println(res)
}