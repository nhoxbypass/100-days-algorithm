package y2025.q3442_maximum_difference_between_even_and_odd_frequency_i

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun maxDifference(s: String): Int {
        var odd = 0
        var even = Int.MAX_VALUE
        val alpha = IntArray(26)

        for (char in s) {
            alpha[char - 'a']++
        }

        for (i in 0 until 26) {
            if (alpha[i] % 2 != 0) odd = maxOf(odd, alpha[i])
            else if (alpha[i] != 0) even = minOf(even, alpha[i])
        }

        return odd - even
    }
}

fun main() {
    val res = Solution().maxDifference(
        "aaaaabbc"
    )
    println(res)
}