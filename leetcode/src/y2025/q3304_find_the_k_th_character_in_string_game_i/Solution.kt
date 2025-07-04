package y2025.q3304_find_the_k_th_character_in_string_game_i

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun kthCharacter(k: Int): Char {
        val s = mutableListOf('a')
        while (s.lastIndex < k - 1) s += s.map { it + 1 }
        return s[k - 1]
    }
}

fun main() {
    val res = Solution().kthCharacter(
        5
    )
    println(res)
}