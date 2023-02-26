fun main(args: Array<String>) {
    val option = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(option)
    val userChoice = getUserChoice(option)
    printResult(userChoice, gameChoice)
}
fun getGameChoice(optionParam: Array<String>) =
    optionParam[(Math.random() * optionParam.size).toInt()]

fun getUserChoice(optionParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    //Выполнять цикл пока пользователь не введет допустимый вариант
    while (!isValidChoice) {
        //Запросить у пользователя его выбор
        print("Please, enter one of the following:")
        for (item in optionParam) print(" $item")
        println(".")
        //Прочитать пользовательский ввод
        val userInput = readLine()
        //Проверить пользовательский ввод
        if (userInput != null && userInput in optionParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //Если выбран недопустимый вариант, сообщить пользователю
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    //Определить результат
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win"
    else result = "You lose!"
    //Вывести результат
    println("You chose $userChoice. I chose $gameChoice. $result")
}


