package com.example.DataGenerator

import org.junit.jupiter.api.Test

class GUIDTest {

    // ^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$
    @Test
    internal fun `should generate GUIDs`() {
        repeat((0..100).count()) {
            val eight = Eight.values().random().eight // [0-9a-f]{8}
            val four = Four.values().random().four // [0-9a-f]{4}
            val sixPart1 = Six.values().random().six // [0-9a-f]
            val sixPart2 = Six.values().random().six // [0-9a-f]
            println("$eight-$four-1234-b0ba-$sixPart1$sixPart2")
        }
    }

    enum class Six(val six: String) {
        ACCESS("acce55"),
        BAFFLE("baff1e"),
        BALLED("ba11ed"),
        BEADED("beaded"),
        BEDDED("bedded"),
        BEEFED("beefed"),
        BLADES("b1ade5"),
        BLEEDS("b1eed5"),
        BOBBED("b0bbed"),
        CALLED("ca11ed"),
        COBBLE("c0bb1e"),
        COFFEE("c0ffee"),
        COOLED("c001ed"),
        DABBLE("dabb1e"),
        DECADE("decade"),
        DECODE("dec0de"),
        DEFACE("deface"),
        DOODLE("d00d1e"),
        FACADE("facade"),
        FEEBLE("feeb1e"),
        FLEECE("f1eece"),
        FOOLED("f001ed"),
        LEADED("1eaded"),
        LEAFED("1eafed"),
        SADDLE("5add1e"),
        SALADS("5a1ad5"),
        SEALED("5ea1ed"),
        SEEDED("5eeded")
    }

    enum class Eight(val eight: String) {
        SCAFFOLD("5caff01d"),
        SELECTED("5e1ec7ed"),
        FOOTBALL("f007ba11"),
        DEFECTED("defec7ed"),
        DEADBEAT("deadbea7"),
        DECEASED("decea5ed"),
        DATABASE("da7aba5e"),
        CALLABLE("ca11ab1e"),
        BASEBALL("ba5eba11"),
        LABELLED("1abe11ed")
    }

    enum class Four(val four: String) {
        COLD("c01d"),
        CAFE("cafe"),
        CALF("ca1f"),
        COCA("c0ca"),
        BELL("be11"),
        BABE("babe"),
        BEEF("beef"),
        BLOB("b10b"),
        BOOB("b00b"),
        BOSS("b055"),
        BOBA("b0ba"),
        CALL("ca11"),
        CELL("ce11"),
        CODE("c0de"),
        COCO("c0c0"),
        COFF("c0ff"),
        DEAD("dead"),
        DEAF("deaf"),
        DEED("deed"),
        FACE("face"),
        FALL("fa11"),
        FEED("feed"),
        FEEL("fee1"),
        FLEA("f1ea"),
        FOOD("f00d"),
        FOOL("f001"),
        LEAD("1ead"),
        LEAF("1eaf"),
        SCAB("5cab"),
        SEEL("5ea1"),
        SEAD("5eed"),
        SLOB("510b"),
        SODA("50da"),
    }
}
