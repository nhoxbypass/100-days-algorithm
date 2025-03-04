package y2025.q1780_check_if_number_is_a_sum_of_powers_of_three

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun checkPowersOfThree(n: Int): Boolean {
        var currNum = n
        while (currNum > 0) {
            if ((currNum % 3) == 2) {
                // currNum % 3 == 0 -> current num can be divided by 3^x
                // currNum % 3 == 1 -> current num can be divided by 3^x + 1 (3^0)
                // currNum % 3 == 2 -> current num can be divided by 3^x + 2 (INVALID)
                return false
            }
            currNum /= 3
        }
        return true
    }
}

fun main() {
    val res = Solution().checkPowersOfThree(
        12
    )
    println(res)
}