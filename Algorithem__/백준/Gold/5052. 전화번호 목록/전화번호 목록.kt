fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    loop@ for (tt in 0 until t) {
        val n = readLine().toInt()
        val tel = mutableListOf<String>()
        for (nn in 0 until n) {
            tel.add(readLine())
        }

        tel.sort()

        for (i in 0 until n - 1) {
            val str = tel[i]
            val target = tel[i + 1]
            if (target.length > str.length && target.substring(0, str.length) == str) {
                println("NO")
                continue@loop
            }
        }
        println("YES")
    }
}