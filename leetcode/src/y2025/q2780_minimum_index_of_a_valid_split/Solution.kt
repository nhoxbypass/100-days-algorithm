package y2025.q2780_minimum_index_of_a_valid_split

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun minimumIndex(nums: List<Int>): Int {
        val domNum = findDominant(nums)

        val domCount = nums.count { it == domNum }

        var lDom = 0
        var lOther = 0
        var rDom = domCount
        var rOther = nums.size - domCount

        for (i in nums.indices) {
            if (nums[i] == domNum) {
                lDom++
                rDom--
            } else {
                lOther++
                rOther--
            }
            if (lDom > lOther && rDom > rOther) {
                return i
            }
        }

        return -1
    }

    private fun findDominant(nums: List<Int>): Int {
        var domNum = -1
        var currCount = 1
        for (num in nums) {
            if (num == domNum) {
                currCount++
            } else {
                currCount--
                if (currCount == 0) {
                    domNum = num
                    currCount = 1
                }
            }
        }
        return domNum
    }
}

fun main() {
    val res = Solution().minimumIndex(
        listOf(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)
    )
    println(res)
}