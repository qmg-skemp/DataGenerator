package com.example.csvgenerator

import com.example.csvgenerator.AppVersion.V3
import com.example.csvgenerator.enum.Customer
import com.example.csvgenerator.enum.Insurer
import com.example.csvgenerator.enum.Referrer
import com.example.csvgenerator.enum.WeightedData
import com.example.csvgenerator.enum.WeightedData.AllocationTagAggregator
import com.example.csvgenerator.enum.WeightedData.AllocationTagDirect
import com.example.csvgenerator.enum.WeightedData.DirectOrAggregator
import com.example.csvgenerator.enum.WeightedData.RenewalStop
import com.example.csvgenerator.enum.WeightedData.YearsFixed
import java.time.LocalDate.now
import java.time.Period
import java.time.format.DateTimeFormatter


data class Ticket(
    val expiryDate: String = randomExpiryDate(),
    val policyId: String = randomPolicyId(),
    val customerId: String = randomCustomerId(),
    val customerName: String = Customer.values().random().customerName,
    val postcode: String = randomPostCode(),
    val expiringPolicyNumber: String = randomExpiringPolicyNumber(),
    val phoneNumber1: String = randomPhoneNumber(),
    val phoneNumber2: String = "",
    val phoneNumber3: String = "",
    val insurer: String = Insurer.values().random().insurer,
    val referrer: String = Referrer.values().random().referrer,
    val twoYearFixed: String = weightedValueFrom(YearsFixed.values().toList()),
    val renewalStop: String = weightedValueFrom(RenewalStop.values().toList()),
    val directOrAggregator: String = weightedValueFrom(DirectOrAggregator.values().toList()),
    val allocationTag: String = when (directOrAggregator) {
        "agg" -> weightedValueFrom(AllocationTagAggregator.values().toList())
        else -> weightedValueFrom(AllocationTagDirect.values().toList())
    },
    val specialityCanveyIsland: String = "FALSE",
    val specialityStormSurge: String = "FALSE",
    val specialityFloodSubsLiability: String = "FALSE",
    val specialityPendingClaims: String = "FALSE",
    val specialityPanelDecline: String = "FALSE",
    val specialityFloodArea: String = "FALSE",
    val specialityCreWatch: String = "FALSE",
    val appOfExpiringPolicy: String = V3.name,
)

private fun randomPhoneNumber(): String = "07${randomNumber(9)}"

private fun randomExpiringPolicyNumber(): String = "35${randomNumber(12)}"

private fun randomNumber(size: Int) = List(size) { (0..9).random() }.joinToString("")

private fun randomPostCode() = "${randomChar((3..4).random())} ${randomChar(3)}".uppercase()

private fun randomCustomerId() = List(11) {
    (('A'..'Z') + ('0'..'9')).random()
}.joinToString("")

private fun randomExpiryDate(): String {
    return now().plus(Period.ofDays((1..60).random())).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}

private fun randomPolicyId(): String {
    return "00${randomChar(5)}-${randomChar(4)}-${randomChar(4)}-${randomChar(4)}-${randomChar(12)}"
}

private fun randomChar(size: Int) = List(size) {
    (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
}.joinToString("")

enum class AppVersion { V3 }

private fun weightedValueFrom(columnValue: List<WeightedData>): String {
    val randomNumber = Math.random() * 100
    var probabilityIterator = 0
    columnValue.forEach {
        probabilityIterator += it.weighting
        if (probabilityIterator >= randomNumber) {
            return it.columnValue
        }
    }
    return " "
}

