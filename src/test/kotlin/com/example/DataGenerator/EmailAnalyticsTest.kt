package com.example.DataGenerator

import com.google.gson.Gson
import org.junit.jupiter.api.Test
import java.io.BufferedWriter
import java.io.FileWriter

class EmailAnalyticsTest {

    @Test
    internal fun `should print loads of emails to a text file`() {
        //        (100..100).forEach { createDummyEmailFile(it) }
        createDummyEmailFile(100)
    }

    private fun createDummyEmailFile(number: Int) {
        val writer =
            BufferedWriter(
                FileWriter(
                    "/Users/scott.kemp/projects/CSVGenerator/src/test/resources/dummy-emails/dummy-emails-$number.txt"
                )
            )

        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "afigg@qmetric.com"))))
        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "pcrotty@qmetric.com"))))
        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "skemp@policyexpert.co.uk"))))
        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "gsmith@policyexpert.co.uk"))))
        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "ujoshi@policyexpert.co.uk"))))
        writer.appendLine(Gson().toJson(Email(msg = Msg(email = "mkaymaklioglu@policyexpert.co.uk"))))
        (7..50000).forEach { _ -> writer.appendLine(Gson().toJson(Email())) }

        writer.flush()
        writer.close()
    }
}
