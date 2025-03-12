package y2025.q1358_number_of_substrings_containing_all_three_characters

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun numberOfSubstrings(s: String): Int {
        var subStrCount = 0
        // store last index of 'a', 'b', 'c' in `s` string
        val lastCharIdx = intArrayOf(-1, -1, -1)

        for ((idx, c) in s.withIndex()) {
            // mark the last index of 'a', 'b', 'c'
            lastCharIdx[c - 'a'] = idx

            // get mix index
            val minIdx = lastCharIdx.min()
            // if the 'a', 'b', 'c' not occur at least one -> this will return -1
            // -> count = -1 + 1 = 0
            val count = minIdx + 1


            subStrCount += count
        }

        return subStrCount
    }
}

fun main() {
    val res = Solution().numberOfSubstrings(
        "abcabc"
    )
    println(res)
}