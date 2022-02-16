package com.example.csvgenerator

import org.apache.commons.csv.CSVFormat.DEFAULT
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.Test
import java.io.FileInputStream

class ReadCSVTest {

    @Test
    internal fun `should be able to read from CSV`() {
        val bufferedReader =
            FileInputStream("/Users/scott.kemp/projects/CSVGenerator/src/test/resources/zendesk.csv").bufferedReader()
        val csvParser = CSVParser(bufferedReader, DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())


        /*for (csvRecord in csvParser) {
            println(
                Ticket(
                    expiry_date = csvRecord.get("expiry_date"),
                    policy_id = csvRecord.get("policy_id"),
                    customer_id = csvRecord.get("customer_id"),
                    customer_name = csvRecord.get("customer_name"),
                    two_year_fixed = csvRecord.get("two_year_fixed"),
                    insurer = csvRecord.get("insurer"),
                    referrer = csvRecord.get("referrer"),
                    Postcode = csvRecord.get("Postcode"),
                    direct_or_aggregator = csvRecord.get("direct_or_aggregator"),
                    speciality_canvey_island = csvRecord.get("speciality_canvey_island"),
                    speciality_storm_surge = csvRecord.get("speciality_storm_surge"),
                    expiring_policy_number = csvRecord.get("expiring_policy_number"),
                    phone_number1 = csvRecord.get("phone_number1"),
                    phone_number2 = csvRecord.get("phone_number2"),
                    phone_number3 = csvRecord.get("phone_number3"),
                    renewal_stop = csvRecord.get("renewal_stop"),
                    speciality_flood_subs_liability = csvRecord.get("speciality_flood_subs_liability"),
                    speciality_pending_claims = csvRecord.get("speciality_pending_claims"),
                    speciality_panel_decline = csvRecord.get("speciality_panel_decline"),
                    speciality_flood_area = csvRecord.get("speciality_flood_area"),
                    speciality_cre_watch = csvRecord.get("speciality_cre_watch"),
                    allocation_tag = csvRecord.get("allocation_tag"),
                    app_of_expiring_policy = csvRecord.get("app_of_expiring_policy"),
                )
            )
        }*/
    }
}