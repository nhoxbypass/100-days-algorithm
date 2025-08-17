package y2025.q1323_maximum_69_number

import kotlin.math.pow

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun maximum69Number(num: Int): Int {
        var plus = 0
        var plusExp = 0.0
        var currNum = num
        while (currNum > 0) {
            val digit = currNum % 10
            if (digit == 6) {
                plus = (3 * 10.0.pow(plusExp).toInt())
            }
            plusExp++
            currNum /= 10
        }
        return num + plus
    }

    fun maximum69NumberOld(num: Int): Int {
        val numDigits = num.toString().toCharArray()
        for (i in 0..<numDigits.size) {
            if (numDigits[i] == '6') {
                numDigits[i] = '9'
                break
            }
        }
        return numDigits.joinToString("").toInt()
    }
}

fun main() {
    val res = Solution().maximum69Number(
        9669
    )
    println(res)
}