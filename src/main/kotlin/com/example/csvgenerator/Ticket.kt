package com.example.csvgenerator

import com.example.csvgenerator.AllocationTag.AGGREGATOR
import com.example.csvgenerator.AllocationTag.DIRECT
import com.example.csvgenerator.AllocationTag.SPECIALITY
import com.example.csvgenerator.AppVersion.V3
import com.example.csvgenerator.enum.WeightedData.DirectOrAggregator
import com.example.csvgenerator.enum.WeightedData.DirectOrAggregator.Agg
import com.example.csvgenerator.enum.WeightedData.FiftyFifty
import com.example.csvgenerator.enum.WeightedData.FiftyFifty.False
import com.example.csvgenerator.enum.WeightedData.FiftyFifty.True
import com.example.csvgenerator.enum.WeightedData.Insurer
import com.example.csvgenerator.enum.WeightedData.Referrer
import com.example.csvgenerator.enum.WeightedData.RenewalStop
import com.example.csvgenerator.enum.WeightedData.YearsFixed
import com.example.csvgenerator.enum.the

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
    val insurer: String = weightedValueFrom(the<Insurer>()),
    val referrer: String = weightedValueFrom(the<Referrer>()),
    val twoYearFixed: String = weightedValueFrom(the<YearsFixed>()),
    val renewalStop: String = weightedValueFrom(the<RenewalStop>()),
    val directOrAggregator: String = weightedValueFrom(the<DirectOrAggregator>()),
    val specialityCanveyIsland: String = False.columnValue,
    val specialityStormSurge: String = False.columnValue,
    val specialityFloodSubsLiability: String = weightedValueFrom(the<FiftyFifty>()),
    val specialityPendingClaims: String = weightedValueFrom(the<FiftyFifty>()),
    val specialityPanelDecline: String = False.columnValue,
    val specialityFloodArea: String = False.columnValue,
    val specialityCreWatch: String = weightedValueFrom(the<FiftyFifty>()),
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
