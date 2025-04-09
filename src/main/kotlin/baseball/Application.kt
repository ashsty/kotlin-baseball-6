package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var status = -1
    println("숫자 야구 게임을 시작합니다.")

    while(status != 2) {
        baseballGame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        status = readLine()?.toInt() ?: -1
    }
}

fun baseballGame() {
    val goal = mutableMapOf<Int, Int>()

    for (index in 0..2) {
        var randomNum = Randoms.pickNumberInRange(1, 9)
        while (goal.containsValue(randomNum)) {
            randomNum = Randoms.pickNumberInRange(1, 9)
        }
        goal[index] = randomNum
    }

    var strike = 0;
    var ball = 0;

    while (strike != 3) {
        print("숫자를 입력해주세요 : ")

        val input = Console.readLine()

        if (input.length != 3) {
            throw IllegalArgumentException("$input is not a valid input for size 3.")
        }

        for(ball in input) {
            if(!ball.isDigit()) {
                throw IllegalArgumentException("It happened because of $ball")
            }
        }

        for(index in 0..2) {
            val guess = input[index].digitToInt()

            for((key, value) in goal) {
                if(guess == value && index == key) {
                    strike++
                }
                if(guess == value && index != key) {
                    ball++
                }
            }
        }

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }

        if(ball == 0 && strike == 0) {
            println("낫싱")
            continue
        }

        if(ball != 0) {
            print("$ball")
            print("볼")
        }

        if(strike != 0) {
            print("$strike")
            print("스트라이크")
        }

        println()

        strike = 0
        ball = 0
    }
}
