import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    try {
        print("Сколько участников: ")
        val n = readln().toInt()
        val users = arrayOfNulls<Github>(n)
        for (i in 0..n - 1) {
            println(i + 1)
            println("Введите логин, пароль и кол-во репозиториев")
            users[i] = Github(readln(), readln(), readln().toInt())
        }
        print("1 - Блокировка\n2 - Другое\nВыберите вариант: ")
        when (readln().toInt())
        {
            1 -> {
                launch {
                    delay(2000L)
                    SortAndWrite(users)
                }
                println("Загрузка участников...")
            }
            2 ->
            {
                println("Программа завершена")
            }
        }
        runBlocking {
            delay(1000L)
        }
    }
    catch (e:Exception)
    {
        println("Неверный формат ввода")
    }
}


suspend fun SortAndWrite(users: Array<Github?>)
{
    for (i in 0..users.size-1)
    {
        for (j in 0..users.size - i - 2)
        {
            var one = users[j]?.repositories
            var two = users[j + 1]?.repositories
            if (one!! > two!!)
            {
                var temp = users[j]
                users[j] = users[j+1]
                users[j+1] = temp
            }
        }
    }
    for (i in 0..users.size-1)
    {
        println(users[i]?.login)
        println(users[i]?.password)
        println(users[i]?.repositories)
    }
}