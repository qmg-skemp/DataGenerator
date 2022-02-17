package com.example.csvgenerator.enum

sealed interface WeightedData {
    val columnValue: String
    val weighting: Int

    enum class YearsFixed(override val columnValue: String, override val weighting: Int) : WeightedData {
        No2YearFixed("no_2yr_fixed", 80),
        Yes12MonthsIn("yes___12_months_in", 10),
        YesExpiringNow("yes___expiring_now", 10)
    }

    enum class DirectOrAggregator(override val columnValue: String, override val weighting: Int) : WeightedData {
        Agg("agg", 90),
        Direct("direct", 10)
    }

    enum class RenewalStop(override val columnValue: String, override val weighting: Int) : WeightedData {
        Yes("yes", 98),
        No("no", 2)
    }

    enum class AllocationTagAggregator(override val columnValue: String, override val weighting: Int) : WeightedData {
        Aggregator("Aggregator", 90),
        Speciality("Speciality", 10)
    }

    enum class AllocationTagDirect(override val columnValue: String, override val weighting: Int) : WeightedData {
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

    enum class Referrer(override val columnValue: String, override val weighting: Int = 0) : WeightedData {
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
