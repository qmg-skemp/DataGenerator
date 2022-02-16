package com.example.csvgenerator

import org.apache.commons.csv.CSVFormat.DEFAULT
import org.apache.commons.csv.CSVPrinter
import org.junit.jupiter.api.Test
import java.io.BufferedWriter
import java.io.FileWriter

class WriteCSVTest {

    @Test
    internal fun `should be able to write to csv file`() {
        val writer =
            BufferedWriter(FileWriter("/Users/scott.kemp/projects/CSVGenerator/src/test/resources/tickets.csv"))

        val headers = listOf(
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
        ).toTypedArray()

        val csvPrinter = CSVPrinter(
            writer, DEFAULT.withHeader(*headers)
        )

        val tickets = listOf(
            Ticket(),
            Ticket(),
            Ticket(),
        )

        for (ticket in tickets) {
            csvPrinter.printRecord(ticket.toCSVList())
        }

        csvPrinter.flush()
        csvPrinter.close()
    }
}