import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    try {
        var result = ""
        print("Сколько рассчётов выполнить: ")
        val n = readln().toInt()
        for (i in 0..n - 1) {
            launch {
                result += Calculate(i)
            }
            runBlocking {
                delay(100L * n)
            }
        }
        println(result)
    }
    catch (e:Exception)
    {
        println("Неверный формат ввода")
    }
}
suspend fun Calculate(i : Int): String {
    var result = ""
    var number1 = i
    var number2 = 5
    result += "Результат (сложение) ${i + 1} = " + (number1 + number2) + "\n"
    result += "Результат (степень) ${i + 1} = " + (Math.pow(number1.toDouble(), number2.toDouble())) + "\n"
    return (result)
}