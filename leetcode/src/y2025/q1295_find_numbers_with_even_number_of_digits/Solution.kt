package y2025.q1295_find_numbers_with_even_number_of_digits

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun findNumbers(nums: IntArray): Int {
        var numberCount = 0
        nums.forEach {
            if (countDigits(it) % 2 == 0) {
                numberCount++
            }
        }
        return numberCount
    }

    private fun countDigits(num: Int): Int {
        var num = num
        var size = 0
        while (num != 0) {
            num /= 10
            size++
        }
        return size
    }
}

fun main() {
    val res = Solution().findNumbers(
        intArrayOf(12, 345, 2, 6, 7896)
    )
    println(res)
}