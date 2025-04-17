package y2025.q2537_count_the_number_of_good_subarrays

class Solution {
    /**
     * - Time complexity: O(N^3)
     * - Space complexity: O(1)
     */
    fun countGood(nums: IntArray, k: Int): Long {
        var count = 0L
        var totalPairs = 0L

        var left = 0
        val freqMap = HashMap<Int, Int>()
        for (right in nums.indices) {
            val currNum = nums[right]

            val currentFreq = freqMap.getOrDefault(currNum, 0)
            totalPairs += currentFreq
            freqMap[currNum] = currentFreq + 1

            while (totalPairs >= k) {
                val leftNum = nums[left]
                totalPairs -= freqMap[leftNum]!! - 1
                freqMap[leftNum] = freqMap[leftNum]!! - 1
                if (freqMap[leftNum] == 0) freqMap.remove(leftNum)
                left++
            }

            count += left
        }

        return count
    }
}

fun main() {
    val res = Solution().countGood(
        intArrayOf(1, 1, 1, 1, 1),
        10
    )
    println(res)
}