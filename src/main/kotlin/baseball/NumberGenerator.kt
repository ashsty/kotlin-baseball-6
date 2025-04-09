package baseball

import camp.nextstep.edu.missionutils.Randoms

private const val NUMBER_SIZE = 3
private const val START_NUM = 1
private const val END_NUM = 9

class NumberGenerator {

    fun generate(): List<Int> {
        val goalNum = mutableSetOf<Int>()

        while (goalNum.size < NUMBER_SIZE) {
            goalNum.add(Randoms.pickNumberInRange(START_NUM, END_NUM))
        }
        return goalNum.toList()
    }
}
