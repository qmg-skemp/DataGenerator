package com.example.csvgenerator

import com.example.csvgenerator.enum.WeightedData
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun randomPhoneNumber(): String = "07${randomNumber(9)}"

fun randomExpiringPolicyNumber(): String = "35${randomNumber(12)}"

fun randomNumber(size: Int) = List(size) { (0..9).random() }.joinToString("")

fun randomPostCode() = "${randomChar((3..4).random())} ${randomChar(3)}".uppercase()

fun randomCustomerId() = List(11) { (('A'..'Z') + ('0'..'9')).random() }.joinToString("")

fun randomExpiryDate(): String =
    LocalDate.now()
        .plus(Period.ofDays((1..60).random()))
        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

fun randomPolicyId(): String =
    "00${randomChar(5)}-${randomChar(4)}-${randomChar(4)}-${randomChar(4)}-${randomChar(12)}"

fun randomChar(size: Int) =
    List(size) { (('a'..'z') + ('A'..'Z') + ('0'..'9')).random() }.joinToString("")

// https://blog.jakelee.co.uk/android-selecting-a-weighted-random-item-from-a-list/
fun weightedValueFrom(columnValue: List<WeightedData>): String {
    val randomNumber = Math.random() * 100
    var probabilityIterator = 0
    columnValue.forEach {
        probabilityIterator += it.weighting
        if (probabilityIterator >= randomNumber) {
            return it.columnValue
        }
    }
    return columnValue[0].columnValue
}
