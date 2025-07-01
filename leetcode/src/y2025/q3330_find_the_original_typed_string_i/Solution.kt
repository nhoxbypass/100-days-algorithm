package y2025.q3330_find_the_original_typed_string_i

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun possibleStringCount(word: String): Int {
        var stringCount = 1

        var prevC = word[0]
        var sameCharCount = 1
        for (idx in 1 until word.length) {
            if (word[idx] == prevC) {
                // same char -> increase char count
                sameCharCount++
            } else {
                // increase the possible string count
                stringCount += (sameCharCount - 1)
                // reset char count
                sameCharCount = 1
                // mark prev char
                prevC = word[idx]
            }
        }
        // increase the possible string count (for the last char)
        stringCount += (sameCharCount - 1)

        return stringCount
    }
}

fun main() {
    val res = Solution().possibleStringCount(
        "abbcccc"
    )
    println(res)
}