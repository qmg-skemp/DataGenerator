package com.example.csvgenerator

import com.example.csvgenerator.AllocationTag.Aggregator
import com.example.csvgenerator.AppVersion.V3
import com.example.csvgenerator.DirectOrAggregator.Agg
import com.example.csvgenerator.RenewalStop.No
import java.time.LocalDate.now
import java.time.Period
import java.time.format.DateTimeFormatter


data class Ticket(
    val expiry_date: String = randomExpiryDate(),
    val policy_id: String = randomPolicyId(),
    val customer_id: String = randomCustomerId(),
    val customer_name: String = Customers.values().random().customer,
    val Postcode: String = randomPostCode(),
    val expiring_policy_number: String = randomExpiringPolicyNumber(),
    val phone_number1: String = randomPhoneNumber(),
    val phone_number2: String = "",
    val phone_number3: String = "",
    val two_year_fixed: String = YearsFixed.values().random().yearsFixed,
    val insurer: String = Insurer.values().random().insurer,
    val referrer: String = Referrer.values().random().referrer,
    val direct_or_aggregator: String = Agg.name.lowercase(),
    val renewal_stop: String = No.name.lowercase(),
    val speciality_canvey_island: Boolean = false,
    val speciality_storm_surge: Boolean = false,
    val speciality_flood_subs_liability: Boolean = false,
    val speciality_pending_claims: Boolean = false,
    val speciality_panel_decline: Boolean = false,
    val speciality_flood_area: Boolean = false,
    val speciality_cre_watch: Boolean = false,
    val allocation_tag: AllocationTag = Aggregator,
    val app_of_expiring_policy: AppVersion = V3,
) {
    fun toCSVList(): List<String> {
        return listOf(
            expiry_date,
            policy_id,
            customer_id,
            customer_name,
            two_year_fixed,
            insurer,
            referrer,
            Postcode,
            direct_or_aggregator,
            speciality_canvey_island.toString().uppercase(),
            speciality_storm_surge.toString().uppercase(),
            expiring_policy_number,
            phone_number1,
            phone_number2,
            phone_number3,
            renewal_stop,
            speciality_flood_subs_liability.toString().uppercase(),
            speciality_pending_claims.toString().uppercase(),
            speciality_panel_decline.toString().uppercase(),
            speciality_flood_area.toString().uppercase(),
            speciality_cre_watch.toString().uppercase(),
            allocation_tag.name,
            app_of_expiring_policy.name
        )
    }

}

private fun randomPhoneNumber(): String {
    return "07${randomNumber(9)}"
}

private fun randomExpiringPolicyNumber(): String {
    return "35${randomNumber(12)}"
}

private fun randomNumber(size: Int) = List(size) { (0..9).random() }.joinToString("")

private fun randomPostCode() =
    "${randomChar((3..4).random())} ${randomChar(3)}".uppercase()

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
enum class AllocationTag { Aggregator, Direct }
enum class RenewalStop { Yes, No }
enum class DirectOrAggregator { Agg, Direct }
enum class Referrer(val referrer: String) {
    RenewalConfused("RENEWAL - CONFUSED"),
    MoneySupermarket("MONEY_SUPERMARKET"),
    RenewalPolicyExpert("RENEWAL - POLICY_EXPERT"),
    RenewalCompareTheMarket("RENEWAL - COMPARE_THE_MARKET"),
    RenewalGoCompare("RENEWAL - GO_COMPARE"),
    RenewalMoneySupermarket("RENEWAL - MONEY_SUPERMARKET"),
    Confused("CONFUSED"),
    CompareTheMarket("COMPARE_THE_MARKET"),
    RenewalBackOffice("RENEWAL - BACKOFFICE"),
    PolicyExpertOMG("POLICY_EXPERT - omg"),
    RenewalQuoteZone("RENEWAL - QUOTE_ZONE"),
    BackOfficeAdjustmentsV3("BACKOFFICE - adjustments_agg_V3"),
    GoCompare("GO_COMPARE"),
    PolicyExpert("POLICY_EXPERT"),
    BackOfficeCustomerHomeMover("BACKOFFICE - existing_customer_home_mover"),
    QuoteZone("QUOTE_ZONE"),
    PolicyExpertCTM("POLICY_EXPERT - ctm"),
    BackOfficeResolout("BACKOFFICE - resoloutbound"),
    RenewalTesco("RENEWAL - TESCO"),
    RenewalReferAFriend("BACKOFFICE - referafriend"),
    BackOfficeOther("BACKOFFICE - other"),
    BackOffice("BACKOFFICE"),
    BackOfficeExpired("BACKOFFICE - expired_renewal"),
    RenewalMustard("RENEWAL - MUSTARD"),
    RenewalExistingCustomer("BACKOFFICE - existing_customer_other"),
    BackOfficeDirectMail("BACKOFFICE - directmail"),
    PolicyExpertReferAFriend("POLICY_EXPERT - referafriend"),
    BackOfficeCancelAndReplace("BACKOFFICE - existing_customer_cancel_and_replace"),
    PolicyExpertMSM("POLICY_EXPERT - msm"),
    BackOfficePreIsured("BACKOFFICE - previously_insured_with_pe"),
    BackOfficeExistingCustomer("BACKOFFICE - Existing customer - Cancel and replace"),
    BackOfficeAdjustments("BACKOFFICE - adjustments_team_agg_policies"),
    PolicyExpertConfused("POLICY_EXPERT - confused"),
    BackOfficeresolemail("BACKOFFICE - resolemail"),
    BackOfficeExistingCustomerMover("BACKOFFICE - Existing customer – home mover"),
    BackOfficeBVCAL("BACKOFFICE - bvocal"),
}

enum class Insurer(val insurer: String) {
    Midas("midas"),
    PeHomeEssentials("pe_home_essentials"),
    PeHomePlus("pe_home_plus"),
    PeHomePremier("pe_home_premier"),
    PeHomeSelect("pe_home_premier")
}

enum class YearsFixed(val yearsFixed: String) {
    No2YearFixed("no_2yr_fixed"),
    Yes12MonthsIn("yes___12_months_in"),
    YesExpiringNow("yes___expiring_now"),
}

enum class Customers(val customer: String) {
    Jack("Mr Jack Bauer"),
    Teri("Mrs Teri Bauer"),
    Nina("Ms Nina Myers"),
    Kim("Miss Kim Bauer"),
    David("Mr David Palmer"),
    Tony("Mr Tony Almeida"),
    Sherry("Miss Sherry Palmer"),
    George("Mr George Mason"),
    Milo("Mr Milo Pressman"),
    Kate("Mrs Kate Warner"),
    Michelle("Miss Michelle Dessler"),
    Chase("Mr Chase Edmunds"),
    Chloe("Miss Chloe O'Brian"),
    Wayne("Mr Wayne Palmer"),
    Audrey("Miss Audrey Raines"),
    Erin("Ms Erin Driscoll"),
    Sarah("Mrs Sarah Gavin"),
    Curtis("Mr Curtis Manning"),
    James("Mr James Heller"),
    Bill("Mr Bill Buchanan"),
    Charles("Mr Charles Logan"),
    Edgar("Mr Edgar Stiles"),
    Martha("Mrs	Martha Logan"),
    Morris("Mr Morris O'Brian"),
    Karen("Mrs Karen Hayes"),
    Tom("Mr Tom Lennox"),
    Nadia("Miss	Nadia Yassir"),
    Sandra("Ms Sandra Palmer"),
    Ethan("Mr Ethan Kanin"),
    Allison("Ms	Allison Taylor"),
    Henry("Mr Henry Taylor"),
    Renee("Mrs Renee Walker"),
    Larry("Mr Larry Moss"),
    Sean("Mr Sean Hillinger"),
    Janis("Mrs Janis Gold"),
    Omar("Mr Omar Hassan"),
    Brian("Mr Brian Hastings"),
    Dana("Mrs Dana Walsh"),
    Rob("Mr	Rob Weiss"),
    Arlo("Mr Arlo Glass"),
    Cole("Mr Cole Ortiz"),
    KateM("Miss	Kate Morgan"),
    Mark("Mr Mark Boudreau"),
    Erik("Mr Erik Ritter"),
    Jordan("Mr Jordan Reed"),
    Adrian("Mr Adrian Cross"),
    Steve("Mr Steve Navarro"),
    Eric("Mr Eric Carter"),
    Rebecca("Miss Rebecca Ingram"),
    Nicole("Mrs Nicole Carter"),
    Keith("Mr Keith Mullins"),
    Isaac("Mr Isaac Carter"),
    Andy("Mr Andy Shalowitz"),
    Mariana("Ms Mariana Stiles"),
    Ben("Mr Ben Grimes"),
    Nilaa("Miss	Nilaa Mizrani"),
    HenryD("Mr Henry Donovan"),
    John("Mr John Donovan")
}
