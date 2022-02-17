package com.example.csvgenerator

import com.example.csvgenerator.enum.Customer
import org.apache.commons.csv.CSVFormat.DEFAULT
import org.apache.commons.csv.CSVPrinter
import org.junit.jupiter.api.Test
import java.io.BufferedWriter
import java.io.FileWriter

class WriteCSVTest {

    @Test
    internal fun `should be able to write to csv file`() {
        val numberOf24Characters = 0..57
        val writer =
            BufferedWriter(
                FileWriter("/Users/scott.kemp/projects/CSVGenerator/src/test/resources/tickets.csv")
            )

        val csvPrinter = CSVPrinter(writer, DEFAULT.withHeader(*headersForZenfriend()))

        val shuffleCharacterNames = numberOf24Characters.shuffled()
        numberOf24Characters.forEach {
            val findCustomerName = Customer.values()[shuffleCharacterNames[it]].customerName
            csvPrinter.printRecord(Ticket(customerName = findCustomerName).toCSVList())
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
