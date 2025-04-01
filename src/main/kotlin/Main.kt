package org.example

// for debug used to print output after X number of concurrent matches
const val debugAfterMatchNum = 11

/**
 * Greek Computer puzzle solution:
 *
 * 5 discs with numbers, stacked on top of each other.
 * The goal is to align the discs so that each column of numbers add up to 42.
 * Each disc has varying rows ranging from 1 to 4, with gaps in them that would
 * show the number beneath if exposed (depicted as a zero in the arrays).
 *
 * This solution brute forces through all possible configurations of the discs.
 */
fun main() {
    for (i in 0..11) {
        for (j in 0..11) {
            for (k in 0..11) {
                for (l in 0..11) {
                    if (checkOffset(0, i, j, k, l)) {
                        println("starting disc indexes: 0 $i $j $k $l")
                        return
                    }
                }
            }
        }
    }
}

/**
 * checks the current column and if matching it checks the next column until all columns have been checked
 */
fun checkOffset(
    indexOne: Int,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    recheck: Int = 0
): Boolean {
    // base case: since indexOne always starts at 0, escape if indexOne is 12
    if (indexOne == 12) return true

    if (recheck > debugAfterMatchNum) println("check #$recheck: indexes: $indexOne $indexTwo $indexThree $indexFour $indexFive")

    val result = if(indexOne < 12)
        getResult(indexOne, indexTwo, indexThree, indexFour, indexFive, recheck > debugAfterMatchNum)
    else 0

    if(recheck > debugAfterMatchNum) println("result: $result")
    return if (result == 42) {
        checkOffset(
            (indexOne + 1),
            (indexTwo + 1) % 12,
            (indexThree + 1) % 12,
            (indexFour + 1) % 12,
            (indexFive + 1) % 12,
            recheck + 1
        )
    } else false
}

/**
 * calculates the total displayed value for the column in the given configuration
 */
fun getResult(
    indexOne: Int,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    show: Boolean = false
): Int {
    return getRow(0, indexOne, indexTwo, indexThree, indexFour, indexFive, show) +
            getRow(1, indexOne, indexTwo, indexThree, indexFour, indexFive, show) +
            getRow(2, indexOne, indexTwo, indexThree, indexFour, indexFive, show) +
            getRow(3, indexOne, indexTwo, indexThree, indexFour, indexFive, show)
}

/**
 * determines which number is displayed in the given row and column
 */
fun getRow(
    rowNum: Int,
    indexOne: Int,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    show :Boolean
): Int {
    val displayedValue = if (one[rowNum][indexOne] != 0) one[rowNum][indexOne]
    else if (two[rowNum][indexTwo] != 0) two[rowNum][indexTwo]
    else if (three[rowNum][indexThree] != 0) three[rowNum][indexThree]
    else if (four[rowNum][indexFour] != 0) four[rowNum][indexFour]
    else five[rowNum][indexFive]

    if(show) println("row: $rowNum (value: $displayedValue)")

    return displayedValue
}


