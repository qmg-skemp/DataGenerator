package com.example.DataGenerator.enum

sealed interface WeightedData {
    val columnValue: String
    val weighting: Int

    enum class YearsFixed(override val columnValue: String, override val weighting: Int) :
        WeightedData {
        No2YearFixed("no_2yr_fixed", 80),
        Yes12MonthsIn("yes___12_months_in", 10),
        YesExpiringNow("yes___expiring_now", 10)
    }

    enum class DirectOrAggregator(override val columnValue: String, override val weighting: Int) :
        WeightedData {
        Agg("Source_aggregator", 90),
        Direct("Source_direct", 10)
    }

    enum class RenewalStop(override val columnValue: String, override val weighting: Int) :
        WeightedData {
        Yes("Home_renewal_stop_yes", 2),
        No("Home_renewal_stop_no", 98)
    }

    enum class AllocationTagAggregator(
        override val columnValue: String,
        override val weighting: Int
    ) : WeightedData {
        Aggregator("Aggregator", 90),
        Speciality("Speciality", 10)
    }

    enum class AllocationTagDirect(override val columnValue: String, override val weighting: Int) :
        WeightedData {
        Aggregator("Direct", 90),
        Speciality("Speciality", 10)
    }

    enum class Insurer(override val columnValue: String, override val weighting: Int) : WeightedData {
        Midas("midas", 1),
        PeHomeEssentials("pe_home_essentials", 8),
        PeHomePlus("pe_home_plus", 3),
        PeHomePremier("pe_home_premier", 2),
        PeHomeSelect("pe_home_select", 86)
    }

    enum class FiftyFifty(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        True("TRUE", 50),
        False("FALSE", 50),
    }

    enum class Event(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        Deferral("deferral", 12),
        Click("click", 12),
        Spam("spam", 12),
        Reject("reject", 12),
        Send("send", 13),
        Open("open", 13),
        Hard_bounce("hard_bounce", 13),
        Soft_bounce("soft_bounce", 13),
    }

    enum class State(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        Deferred("deferred", 12),
        Rejected("rejected", 12),
        Bounced("bounced", 12),
        Spam("spam", 12),
        Send("send", 13),
        Unsub("unsub", 13),
        Softbounced("soft-bounced", 13),
        Sent("sent", 13),
    }

    enum class Template(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        PurchaseCancelled("purchase-confirmation", 10),
        LeadInsuer("v2-renewal-quote-lead-insurer", 10),
        PasswordReset("v2-password-reset-token", 10),
        MonthlyConfirmation("v2-purchase-confirmation-monthly", 10),
        QuoteConfirmationV2("v2-quote-confirmation", 10),
        QuoteConfirmation("quote-confirmation", 10),
        AnnualConfirmation("v2-purchase-confirmation-annual", 10),
        PolicyCancelled("policy-cancelled", 10),
        MCEmailAdded("mc-email-added", 10),
        RenewalLapsed("v10-renewal-lapsed", 10)
    }

    enum class Subject(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        PConfirm("Your purchase confirmation", 20),
        RHome("Time to renew your Home Insurance", 20),
        EIQ("Your Home Emergency insurance quote", 20),
        HIQ("Your Home insurance quote", 20),
        PReset("Policy Expert Password Reset", 20),
    }

    enum class Tags(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        Tag1("order-adjusted", 10),
        Tag2("deferred-cancellation", 10),
        Tag3("email-authentication", 10),
        Tag4("live-email-v3", 10),
        Tag5("renewal-stop-reminder", 10),
        Tag6("cancellation-confirmation", 10),
        Tag7("password-reset", 10),
        Tag8("renewal-reminder", 10),
        Tag9("live-email", 10),
        Tag10("test-email", 10)
    }

    enum class Email(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        Email1("gmail.com", 10),
        Email2("aol.com", 10),
        Email3("hotmail.com", 10),
        Email4("btinternet.com", 10),
        Email5("qmetric.co.uk", 10),
        Email6("btopenworld.com", 10),
        Email7("policyexpert.co.uk", 10),
        Email8("sky.com", 10),
        Email9("yahoo.co.uk", 10),
        Email10("hotmail.co.uk", 10),
    }

    enum class Referrer(override val columnValue: String, override val weighting: Int = 0) :
        WeightedData {
        RenewalCompareTheMarket("RENEWAL - COMPARE_THE_MARKET", 30),
        CompareTheMarket("COMPARE_THE_MARKET", 17),
        RenewalMoneySupermarket("RENEWAL - MONEY_SUPERMARKET", 14),
        RenewalBackOffice("RENEWAL - BACKOFFICE", 8),
        MoneySupermarket("MONEY_SUPERMARKET", 7),
        RenewalGoCompare("RENEWAL - GO_COMPARE", 7),
        Confused("CONFUSED", 4),
        RenewalConfused("RENEWAL - CONFUSED", 4),
        GoCompare("GO_COMPARE", 4),
        RenewalPolicyExpert("RENEWAL - POLICY_EXPERT", 2),
        PolicyExpertOMG("POLICY_EXPERT - omg", 1),
        BackOfficeAdjustmentsV3("BACKOFFICE - adjustments_agg_V3", 1),
        RenewalQuoteZone("RENEWAL - QUOTE_ZONE", 1),
        PolicyExpert("POLICY_EXPERT"),
        BackOfficeCustomerHomeMover("BACKOFFICE - existing_customer_home_mover"),
        QuoteZone("QUOTE_ZONE"),
        PolicyExpertCTM("POLICY_EXPERT - ctm"),
        BackOfficeResolout("BACKOFFICE - resoloutbound"),
        RenewalTesco("RENEWAL - TESCO"),
        RenewalReferAFriend("BACKOFFICE - referafriend"),
        BackOfficeOther("BACKOFFICE - other"),
        BackOfficeExpired("BACKOFFICE - expired_renewal"),
        RenewalMustard("RENEWAL - MUSTARD"),
        RenewalExistingCustomer("BACKOFFICE - existing_customer_other"),
        BackOfficeDirectMail("BACKOFFICE - directmail"),
        PolicyExpertReferAFriend("POLICY_EXPERT - referafriend"),
        BackOfficeCancelAndReplace("BACKOFFICE - existing_customer_cancel_and_replace"),
        PolicyExpertMSM("POLICY_EXPERT - msm"),
        BackOfficePreIsured("BACKOFFICE - previously_insured_with_pe"),
        BackOfficeExistingCustomer("BACKOFFICE - Existing customer - Cancel and replace"),
        PolicyExpertConfused("POLICY_EXPERT - confused"),
        BackOfficeresolemail("BACKOFFICE - resolemail"),
        BackOfficeExistingCustomerMover("BACKOFFICE - Existing customer – home mover"),
        BackOfficeBVCAL("BACKOFFICE - bvocal"),
        BackOfficeAdjustments("BACKOFFICE - adjustments_team_agg_policies"),
        BackOffice("BACKOFFICE")
    }
}

inline fun <reified T : Enum<T>> the(): List<T> {
    return enumValues<T>().toList()
}
