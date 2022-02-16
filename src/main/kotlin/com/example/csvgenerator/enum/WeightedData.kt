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
        No("no", 1)
    }

    enum class AllocationTagAggregator(override val columnValue: String, override val weighting: Int) : WeightedData {
        Aggregator("Aggregator", 90),
        Speciality("Speciality", 10)
    }

    enum class AllocationTagDirect(override val columnValue: String, override val weighting: Int) : WeightedData {
        Aggregator("Direct", 90),
        Speciality("Speciality", 10)
    }
}
