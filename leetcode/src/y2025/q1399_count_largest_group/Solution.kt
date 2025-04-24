package y2025.q1399_count_largest_group

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun countLargestGroup(n: Int): Int {
        val sumGroups = (1..n).groupingBy {
            computeDigitSum(it)
        }.eachCount()

        val maxGroupSize = sumGroups.values.max()

        return sumGroups.count { it.value == maxGroupSize }
    }

    private fun computeDigitSum(num: Int): Int {
        var digitSum = 0
        var currNum = num
        while (currNum > 0) {
            digitSum += currNum % 10
            currNum /= 10
        }
        return digitSum
    }
}

fun main() {
    val res = Solution().countLargestGroup(
        13
    )
    println(res)
}