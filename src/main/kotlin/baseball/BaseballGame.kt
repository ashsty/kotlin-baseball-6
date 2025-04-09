package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame {

    fun play() {
        val numberGenerator = NumberGenerator()
        val goal = numberGenerator.generate()

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

                for(value in goal) {
                    val digit = goal.indexOf(value)
                    if(guess == value && index == digit) {
                        strike++
                    }
                    else if(guess == value) {
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
}
