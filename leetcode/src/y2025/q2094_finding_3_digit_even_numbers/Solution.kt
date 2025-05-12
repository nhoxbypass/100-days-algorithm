package y2025.q2094_finding_3_digit_even_numbers

class Solution {
    /**
     * - Time complexity: O(N^3)
     * - Space complexity: O(1)
     */
    fun findEvenNumbers(digits: IntArray): IntArray {
        val N = digits.size
        val result = HashSet<Int>()
        for (i in 0..N - 1) {
            if (digits[i] == 0) {
                // avoid leading zeros
                continue
            }
            for (j in 0 until N) {
                if (j == i) {
                    // same idx
                    continue
                }
                for (k in 0 until N) {
                    if (k == i || k == j) {
                        // same idx
                        continue
                    }
                    if (digits[k] % 2 != 0) {
                        // not EVEN number
                        continue
                    }
                    // VALID number
                    val num = digits[i] * 100 + digits[j] * 10 + digits[k]
                    result.add(num)
                }
            }
        }
        // sort
        // return result
        return result.sorted().toIntArray()
    }
}

fun main() {
    val res = Solution().findEvenNumbers(
        intArrayOf(2, 1, 3, 0)
    )
    println(res)
}