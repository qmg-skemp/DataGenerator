package com.example.csvgenerator

import org.apache.commons.csv.CSVFormat.DEFAULT
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.Test
import java.io.FileInputStream

class ReadCSVTest {

    @Test
    internal fun `should be able to read from CSV`() {
        val bufferedReader =
            FileInputStream("/Users/scott.kemp/projects/CSVGenerator/src/test/resources/tickets.csv")
                .bufferedReader()
        val csvParser =
            CSVParser(
                bufferedReader, DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
            )

        for (csvRecord in csvParser) {
            println(
                Ticket(
                    expiryDate = csvRecord.get("expiry_date"),
                    policyId = csvRecord.get("policy_id"),
                    customerId = csvRecord.get("customer_id"),
                    customerName = csvRecord.get("customer_name"),
                    twoYearFixed = csvRecord.get("two_year_fixed"),
                    insurer = csvRecord.get("insurer"),
                    referrer = csvRecord.get("referrer"),
                    postcode = csvRecord.get("Postcode"),
                    directOrAggregator = csvRecord.get("direct_or_aggregator"),
                    specialityCanveyIsland = csvRecord.get("speciality_canvey_island"),
                    specialityStormSurge = csvRecord.get("speciality_storm_surge"),
                    expiringPolicyNumber = csvRecord.get("expiring_policy_number"),
                    phoneNumber1 = csvRecord.get("phone_number1"),
                    phoneNumber2 = csvRecord.get("phone_number2"),
                    phoneNumber3 = csvRecord.get("phone_number3"),
                    renewalStop = csvRecord.get("renewal_stop"),
                    specialityFloodSubsLiability = csvRecord.get("speciality_flood_subs_liability"),
                    specialityPendingClaims = csvRecord.get("speciality_pending_claims"),
                    specialityPanelDecline = csvRecord.get("speciality_panel_decline"),
                    specialityFloodArea = csvRecord.get("speciality_flood_area"),
                    specialityCreWatch = csvRecord.get("speciality_cre_watch"),
                    allocationTag = csvRecord.get("allocation_tag"),
                    appOfExpiringPolicy = csvRecord.get("app_of_expiring_policy")
                )
            )
        }
    }
}
