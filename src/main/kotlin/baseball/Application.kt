package baseball

fun main() {

    var gameStatus = -1
    println("숫자 야구 게임을 시작합니다.")

    val baseballGame = BaseballGame()

    while(gameStatus != 2) {
        baseballGame.play()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameStatus = readLine()?.toInt() ?: -1
    }
}
