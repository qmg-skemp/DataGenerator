package com.example.DataGenerator

import com.example.DataGenerator.enum.WeightedData.Email
import com.example.DataGenerator.enum.WeightedData.Event
import com.example.DataGenerator.enum.WeightedData.State
import com.example.DataGenerator.enum.WeightedData.Subject
import com.example.DataGenerator.enum.WeightedData.Tags
import com.example.DataGenerator.enum.WeightedData.Template
import com.example.DataGenerator.enum.the
import java.math.BigInteger
import java.util.UUID

data class Email(
    val ts: BigInteger = randomNumberInt(10),
    val ip: String = randomIPAddress(),
    val _id: String = UUID.randomUUID().toString(),
    val event: String = weightedValueFrom(the<Event>()),
    val msg: Msg = Msg(ts = ts, _id = _id),
    val location: Location = Location(),
    val userAgent: String =
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko)",
    val userAgentParsed: UserAgentParsed = UserAgentParsed()
)

data class Msg(
    val ts: BigInteger = randomNumberInt(10),
    val _id: String = UUID.randomUUID().toString(),
    val tags: List<String> = listOf(weightedValueFrom(the<Tags>()), weightedValueFrom(the<Tags>())),
    val email: String = "${randomEmailSig()}${randomNumber(3)}@${weightedValueFrom(the<Email>())}",
    val opens: List<String> = emptyList(),
    val state: String = weightedValueFrom(the<State>()),
    val clicks: List<String> = emptyList(),
    val sender: String = "ask@policyexpert.co.uk",
    val resends: List<String> = emptyList(),
    val subject: String =
        "${weightedValueFrom(the<Subject>())}  ${Customer.values().random().customerName}",
    val template: String = weightedValueFrom(the<Template>())
)

data class Location(
    val city: String = "Wolverhampton",
    val region: String = "England",
    val country: String = "United Kingdom",
    val latitude: Double = 52.5854682922,
    val longitude: Double = -2.12296009064,
    val timezone: String = "+01:00",
    val postal_code: String = "CM2 9QR",
    val country_short: String = "GB"
)

data class UserAgentParsed(
    val type: String = "Email Client",
    val mobile: Boolean = false,
    val os_url: String = "http://www.apple.com/osx/",
    val ua_url: String = "http://en.wikipedia.org/wiki/Apple_mail",
    val os_icon: String = "http://cdn.mandrill.com/img/email-client-icons/macosx.png",
    val os_name: String = "OS X",
    val ua_icon: String = "http://cdn.mandrill.com/img/email-client-icons/apple-mail.png",
    val ua_name: String = "Apple Mail",
    val os_family: String = "OS X",
    val ua_family: String = "Apple Mail",
    val os_company: String = "AppleComputer, Inc.",
    val ua_company: String = "Apple Inc.",
    val os_company_url: String = "http://www.apple.com/",
    val ua_company_url: String = "http://www.apple.com/"
)
