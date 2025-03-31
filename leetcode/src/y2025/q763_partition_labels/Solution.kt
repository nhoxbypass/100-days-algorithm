package y2025.q763_partition_labels

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun partitionLabels(s: String): List<Int> {
        // find the last index of each char in `s`
        val lastIndices = mutableMapOf<Char, Int>()
        for ((idx, c) in s.withIndex()) {
            lastIndices[c] = idx
        }

        var partitionStart = 0
        var partitionEnd = -1
        val partitions = mutableListOf<Int>()
        for ((idx, c) in s.withIndex()) {
            // last index of char 'c'
            val lastIdxOfC = lastIndices.getOrDefault(c, 0)
            partitionEnd = maxOf(partitionEnd, lastIdxOfC)
            if (idx == partitionEnd) {
                // split a partition [partitionStart - idx]
                partitions.add(idx - partitionStart + 1)
                // start a new partition
                partitionStart = idx + 1
            }
        }

        return partitions
    }
}

fun main() {
    val res = Solution().partitionLabels(
        "ababcbacadefegdehijhklij"
    )
    println(res)
}