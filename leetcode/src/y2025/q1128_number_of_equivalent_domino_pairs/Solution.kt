package y2025.q1128_number_of_equivalent_domino_pairs

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val N = dominoes.size
        // Map <domino sum, freq count>
        val dominoSumFreqCount = HashMap<Int, Int>()
        var pairCount = 0
        for (i in 0..N - 1) {
            // calculate domino sum
            // sum = big domino * 10 + small domino
            val dominoSum = if (dominoes[i][0] > dominoes[i][1]) {
                dominoes[i][0] * 10 + dominoes[i][1]
            } else {
                dominoes[i][1] * 10 + dominoes[i][0]
            }
            // increase freq count
            dominoSumFreqCount.getOrDefault(dominoSum, 0).let {
                dominoSumFreqCount[dominoSum] = it + 1
                pairCount += it
            }
        }
        return pairCount
    }

    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun numEquivDominoPairsLegacy(dominoes: Array<IntArray>): Int {
        val N = dominoes.size
        var pairCount = 0
        for (i in 0..N - 2) {
            for (j in i + 1..N - 1) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                    || (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])
                ) {
                    pairCount++
                }
            }
        }
        return pairCount
    }
}

fun main() {
    val res = Solution().numEquivDominoPairs(
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 6))
    )
    println(res)
}