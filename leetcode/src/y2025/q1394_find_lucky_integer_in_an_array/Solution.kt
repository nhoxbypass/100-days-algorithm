package y2025.q1394_find_lucky_integer_in_an_array

import kotlin.math.max

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun findLucky(arr: IntArray): Int {
        val freqCount = IntArray(501) // because: 1 <= arr[i] <= 500`
        arr.forEach { num ->
            freqCount[num]++
        }

        for (num in freqCount.size - 1 downTo 1) {
            if (num == freqCount[num]) return num
        }

        return -1
    }

    fun findLuckyOld(arr: IntArray): Int {
        val freqCount = HashMap<Int, Int>()
        arr.forEach { num ->
            freqCount[num] = freqCount.getOrDefault(num, 0) + 1
        }

        var largestLuckyNum = -1
        arr.forEach { num ->
            if (num == freqCount.getOrDefault(num, 0)) {
                largestLuckyNum = max(largestLuckyNum, num)
            }
        }

        return largestLuckyNum
    }
}

fun main() {
    val res = Solution().findLucky(
        intArrayOf(2, 2, 3, 4)
    )
    println(res)
}