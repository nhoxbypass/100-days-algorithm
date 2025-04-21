package y2025.q781_rabbits_in_forest

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun numRabbits(answers: IntArray): Int {
        val sameColorCountMap = HashMap<Int, Int>()
        var totalCount = 0
        // travel through answers of the rabbits
        answers.forEach { sameColor ->
            if (sameColor == 0) {
                // this rabbit has UNIQUE COLOR
                totalCount++
                return@forEach
            }
            val currCount = sameColorCountMap.getOrDefault(sameColor, 0)
            if (currCount == 0) {
                // this rabbit has NEW COLOR
                // increase rabbit count
                totalCount += (sameColor + 1)
                sameColorCountMap[sameColor] = sameColor
            } else {
                // OLD COLOR
                sameColorCountMap[sameColor] = currCount - 1
            }
        }
        return totalCount
    }
}

fun main() {
    val res = Solution().numRabbits(
        intArrayOf(0, 0, 1, 1, 1)
    )
    println(res)
}