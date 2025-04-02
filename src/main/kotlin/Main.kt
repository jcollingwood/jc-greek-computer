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
                    // recursively checks current iteration of discs starting at the current iteration of indexes,
                    // returning false if one of the columns at this starting index does not match or true if all
                    // 12 columns satisfy the 42 sum condition
                    if (checkOffset(indexTwo = i, indexThree = j, indexFour = k, indexFive = l)) {
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
    indexOne: Int = 0,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    recheckCounter: Int = 0
): Boolean {
    // base case: since indexOne always starts at 0, escape if indexOne is 12
    if (indexOne == 12) return true

    // debugging log statement
     println("check #$recheckCounter: indexes: $indexOne $indexTwo $indexThree $indexFour $indexFive")

    val columnSum = calculateSumOfColumn(indexOne, indexTwo, indexThree, indexFour, indexFive, recheckCounter > debugAfterMatchNum)

    // continue checking rest of columns if columnSum satisfies expected sum of 42, otherwise return,
    // this iteration of indexes is not the solution
    return if (columnSum == 42) {
        checkOffset(
            (indexOne + 1),
            (indexTwo + 1) % 12,
            (indexThree + 1) % 12,
            (indexFour + 1) % 12,
            (indexFive + 1) % 12,
            recheckCounter + 1
        )
    } else false
}

/**
 * calculates the total displayed value for the column in the given configuration
 */
fun calculateSumOfColumn(
    indexOne: Int,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    debugValue: Boolean = false
): Int {
    // gets the displayed value for each of the 4 rows
    val columnSum = getDisplayedValue(0, indexOne, indexTwo, indexThree, indexFour, indexFive, debugValue) +
            getDisplayedValue(1, indexOne, indexTwo, indexThree, indexFour, indexFive, debugValue) +
            getDisplayedValue(2, indexOne, indexTwo, indexThree, indexFour, indexFive, debugValue) +
            getDisplayedValue(3, indexOne, indexTwo, indexThree, indexFour, indexFive, debugValue)

    // debugging log statement
    if (debugValue) println("result: $columnSum")

    return columnSum
}

/**
 * determines which number is displayed in the given row and column
 */
fun getDisplayedValue(
    rowNum: Int,
    indexOne: Int,
    indexTwo: Int,
    indexThree: Int,
    indexFour: Int,
    indexFive: Int,
    debugValue :Boolean
): Int {
    val displayedValue = if (one[rowNum][indexOne] != 0) one[rowNum][indexOne]
    else if (two[rowNum][indexTwo] != 0) two[rowNum][indexTwo]
    else if (three[rowNum][indexThree] != 0) three[rowNum][indexThree]
    else if (four[rowNum][indexFour] != 0) four[rowNum][indexFour]
    else five[rowNum][indexFive]

    if(debugValue) println("row: $rowNum (value: $displayedValue)")

    return displayedValue
}


