package com.example.csvgenerator

import org.apache.commons.csv.CSVFormat.DEFAULT
import org.apache.commons.csv.CSVPrinter
import org.junit.jupiter.api.Test
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class WriteCSVTest {

    @Test
    internal fun `should be able to write to csv file`() {
        val customerNames = File("src/test/resources/people.txt").readLines().shuffled()

        val writer =
            BufferedWriter(
                FileWriter("/Users/scott.kemp/projects/CSVGenerator/src/test/resources/tickets.csv")
            )

        val csvPrinter = CSVPrinter(writer, DEFAULT.withHeader(*headersForZenfriend()))

        (0..100).forEach {
            csvPrinter.printRecord(
                if (it < customerNames.size) Ticket(customerName = customerNames[it].trim()).toCSVList()
                else Ticket().toCSVList()
            )
        }

        csvPrinter.flush()
        csvPrinter.close()
    }

    private fun headersForZenfriend(): Array<String> {
        return listOf(
            "expiry_date",
            "policy_id",
            "customer_id",
            "customer_name",
            "two_year_fixed",
            "insurer",
            "referrer",
            "Postcode",
            "direct_or_aggregator",
            "speciality_canvey_island",
            "speciality_storm_surge",
            "expiring_policy_number",
            "phone_number1",
            "phone_number2",
            "phone_number3",
            "renewal_stop",
            "speciality_flood_subs_liability",
            "speciality_pending_claims",
            "speciality_panel_decline",
            "speciality_flood_area",
            "speciality_cre_watch",
            "allocation_tag",
            "app_of_expiring_policy"
        )
            .toTypedArray()
    }

    private fun Ticket.toCSVList(): List<String> {
        return listOf(
            expiryDate,
            policyId,
            customerId,
            customerName,
            twoYearFixed,
            insurer,
            referrer,
            postcode,
            directOrAggregator,
            specialityCanveyIsland,
            specialityStormSurge,
            expiringPolicyNumber,
            phoneNumber1,
            phoneNumber2,
            phoneNumber3,
            renewalStop,
            specialityFloodSubsLiability,
            specialityPendingClaims,
            specialityPanelDecline,
            specialityFloodArea,
            specialityCreWatch,
            allocationTag,
            appOfExpiringPolicy
        )
    }
}
