package org.example

import kotlin.Array
import kotlin.Int

val zeroRow = Array<Int>(12) { 0 }

val one = arrayOf(
    arrayOf(15,  0,  8,  0,  3,  0,  6,  0, 10,  0,  7,  0),
    zeroRow,
    zeroRow,
    zeroRow
)
val two = arrayOf(
    arrayOf(11,  0,  6, 17,  7,  3,  0,  6,  0, 11, 11,  6),
    arrayOf( 9,  0, 12,  0,  4,  0,  7, 15,  0,  0, 14,  0),
    zeroRow,
    zeroRow
)
val three = arrayOf(
    arrayOf( 8,  9, 13,  9,  7, 13, 21, 17,  4,  5,  0,  7),
    arrayOf( 0, 21,  6, 15,  4,  9, 18, 11, 26, 14,  1, 12),
    arrayOf( 0,  5,  0, 10,  0,  8,  0, 22,  0, 16,  0,  9),
    zeroRow
)
val four = arrayOf(
    arrayOf( 7, 14, 11,  0,  8,  0, 16,  2,  7, 14,  9,  0),
    arrayOf( 6,  0, 14, 12,  3,  8,  9,  0,  9, 20, 12,  3),
    arrayOf( 2, 13,  9,  0, 17, 19,  3, 12,  3, 26,  6,  0),
    arrayOf(12,  0,  6,  0, 10,  0, 10,  0,  1,  0,  9,  0)
)
val five = arrayOf(
    arrayOf(11, 14, 11, 11, 14, 11, 14, 11, 14, 14, 12, 14),
    arrayOf(14, 15,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13),
    arrayOf( 9,  9,  4,  4,  6,  6,  3,  3, 14, 14, 21, 21),
    arrayOf( 7,  8,  8,  3,  4, 12,  2,  5, 10,  7, 16,  8)
)
