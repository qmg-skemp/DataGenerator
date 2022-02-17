package com.example.csvgenerator

import com.example.csvgenerator.AllocationTag.AGGREGATOR
import com.example.csvgenerator.AllocationTag.DIRECT
import com.example.csvgenerator.AllocationTag.SPECIALITY
import com.example.csvgenerator.AppVersion.V3
import com.example.csvgenerator.enum.WeightedData.DirectOrAggregator
import com.example.csvgenerator.enum.WeightedData.DirectOrAggregator.Agg
import com.example.csvgenerator.enum.WeightedData.FiftyFifty
import com.example.csvgenerator.enum.WeightedData.FiftyFifty.True
import com.example.csvgenerator.enum.WeightedData.Insurer
import com.example.csvgenerator.enum.WeightedData.Referrer
import com.example.csvgenerator.enum.WeightedData.RenewalStop
import com.example.csvgenerator.enum.WeightedData.YearsFixed

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
    val insurer: String = weightedValueFrom(Insurer.values().toList()),
    val referrer: String = weightedValueFrom(Referrer.values().toList()),
    val twoYearFixed: String = weightedValueFrom(YearsFixed.values().toList()),
    val renewalStop: String = weightedValueFrom(RenewalStop.values().toList()),
    val directOrAggregator: String = weightedValueFrom(DirectOrAggregator.values().toList()),
    val specialityCanveyIsland: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityStormSurge: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityFloodSubsLiability: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityPendingClaims: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityPanelDecline: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityFloodArea: String = weightedValueFrom(FiftyFifty.values().toList()),
    val specialityCreWatch: String = weightedValueFrom(FiftyFifty.values().toList()),
    val allocationTag: String =
        when {
            specialityPendingClaims == True.columnValue -> SPECIALITY.tagName
            specialityFloodSubsLiability == True.columnValue -> SPECIALITY.tagName
            directOrAggregator == Agg.columnValue -> AGGREGATOR.tagName
            else -> DIRECT.tagName
        },
    val appOfExpiringPolicy: String = V3.name,
)

enum class AllocationTag(val tagName: String) {
    SPECIALITY("Speciality"),
    AGGREGATOR("Aggregator"),
    DIRECT("Direct")
}

enum class AppVersion {
    V3
}
