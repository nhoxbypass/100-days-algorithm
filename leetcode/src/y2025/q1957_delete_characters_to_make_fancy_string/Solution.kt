package y2025.q1957_delete_characters_to_make_fancy_string

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun makeFancyString(input: String): String {
        val fancyString = StringBuilder()
        var prevC = ' '
        var sameCharCount = 0
        for (c in input) {
            if (c != prevC) {
                fancyString.append(c)
                sameCharCount = 1
            } else if (sameCharCount < 2) {
                fancyString.append(c)
                ++sameCharCount
            }
            prevC = c
        }
        return fancyString.toString()
    }
}

fun main() {
    val res = Solution().makeFancyString(
        "leeetcode"
    )
    println(res)
}